package com.krotos.roomreservationservice

import org.apache.http.HttpException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.text.ParseException
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/room-reservations")
class RoomReservationFeignWebService(
    val roomClient: RoomClient,
    val reservationClient: ReservationClient,
    val guestClient: GuestClient
) {

    @GetMapping
    fun getRoomReservations(
        @RequestParam(name = "date", required = false) dateString: String?
    ): List<RoomReservation>? {

        validateDate(dateString)
        val rooms = roomClient.getAllRooms()
        val reservations = reservationClient.getAllReservations(dateString)

        return rooms
            ?.map { RoomReservation(it) }
            ?.map { it.updateReservationDetails(reservations.find { res -> res.roomId == it.roomId }) }
            ?.map { it.updateGuestDetails(downloadGuestData(it.guestId)) }
    }

    private fun validateDate(dateString: String?) {
        if (dateString == null) return
        try {
            SimpleDateFormat("yyyy-MM-dd").parse(dateString)
        } catch (ex: ParseException){
            throw HttpException("Date not parsable, date should be: 2020-01-01, is ${dateString}")
        }
    }

    private fun downloadGuestData(guestId: Long?): Guest? {
        if (guestId == null) return null
        return guestClient.getGuest(guestId)
    }
}
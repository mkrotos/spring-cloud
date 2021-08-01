package com.krotos.roomreservationservice

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("roomservices")
interface RoomClient {
    @GetMapping("/rooms")
    fun getAllRooms(): List<Room>?

    @GetMapping("/rooms/{id}")
    fun getRoom(@PathVariable("id") id: Long): Room?
}

@FeignClient("reservationservices")
interface ReservationClient {
    @GetMapping("/reservations")
    fun getAllReservations(@RequestParam(name = "date", required = false) dateString: String?): List<Reservation>
}

@FeignClient("guestservices")
interface GuestClient {
    @GetMapping("/guests")
    fun getAllGuests(): List<Guest>

    @GetMapping("/guests/{id}")
    fun getGuest(@PathVariable("id") id: Long): Guest?

}
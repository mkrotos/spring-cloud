package com.krotos.roomreservationservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/room-reservations")
class RoomReservationFeignWebService(val roomClient: RoomClient) {

    @GetMapping
    fun getRoomReservations(): List<RoomReservation>? {
        val allRooms = roomClient.getAllRooms()
        return allRooms?.map { RoomReservation(it) }
    }
}
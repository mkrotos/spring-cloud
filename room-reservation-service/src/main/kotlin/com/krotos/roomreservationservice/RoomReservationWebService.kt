package com.krotos.roomreservationservice

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/room-reservations2")
class RoomReservationWebService(val restTemplate: RestTemplate) {

    @GetMapping
    fun getRoomReservations(): List<RoomReservation>? {
        val allRooms = getAllRooms()
        return allRooms?.map { RoomReservation(it) }
    }

    fun getAllRooms(): List<Room>? {
        val roomsResponse = restTemplate.exchange("http://ROOMSERVICES/rooms",
            HttpMethod.GET, null, object : ParameterizedTypeReference<List<Room>>() {})
        return roomsResponse.body
    }

}
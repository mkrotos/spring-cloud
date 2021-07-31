package com.krotos.roomreservationservice

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient("roomservices")
interface RoomClient {
    @GetMapping("/rooms")
    fun getAllRooms(): List<Room>?

    @GetMapping("/rooms/{id}")
    fun getRoom(@PathVariable("id") id: Long): Room?
}
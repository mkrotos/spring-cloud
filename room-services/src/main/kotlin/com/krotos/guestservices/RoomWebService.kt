package com.krotos.guestservices

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rooms")
class RoomWebService(val repository: RoomRepository) {

    @GetMapping
    fun getAllRooms(): Iterable<Room> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getRoom(@PathVariable("id") id:Long): Room {
        return repository.findById(id).get()
    }

}
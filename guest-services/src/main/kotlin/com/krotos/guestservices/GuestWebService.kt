package com.krotos.guestservices

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/guests")
class GuestWebService(val repository: GuestRepository) {

    @GetMapping
    fun getAllGuests(): Iterable<Guest> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getGuest(@PathVariable("id") id:Long): Guest {
        return repository.findById(id).get()
    }

}
package com.krotos.guestservices

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reservations")
class ReservationWebService(val repository: ReservationRepository) {

    @GetMapping
    fun getAllReservations(): Iterable<Reservation> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun getReservation(@PathVariable("id") id:Long): Reservation {
        return repository.findById(id).get()
    }

}
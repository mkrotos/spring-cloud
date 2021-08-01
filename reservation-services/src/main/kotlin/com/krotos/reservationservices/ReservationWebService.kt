package com.krotos.reservationservices

import org.springframework.web.bind.annotation.*
import java.text.ParseException
import java.text.SimpleDateFormat

@RestController
@RequestMapping("/reservations")
class ReservationWebService(val repository: ReservationRepository) {

    @GetMapping
    fun getAllReservations(@RequestParam(name = "date", required = false) dateString: String?): Iterable<Reservation> {
        val date = try {
            dateString?.map { SimpleDateFormat("yyyy-MM-dd").parse(dateString) }?.first()
        } catch (ex: ParseException) {
            null
        }

        return if (date != null) repository.findAllByReservationDate(date) else repository.findAll()
    }

    @GetMapping("/{id}")
    fun getReservation(@PathVariable("id") id: Long): Reservation {
        return repository.findById(id).get()
    }

}
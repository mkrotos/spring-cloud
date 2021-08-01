package com.krotos.reservationservices

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReservationRepository : CrudRepository<Reservation, Long> {
    fun findAllByReservationDate(date: Date): List<Reservation>
}
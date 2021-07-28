package com.krotos.guestservices

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : CrudRepository<Reservation, Long>
package com.krotos.roomreservationservice

import java.util.*

class RoomReservation(
    var roomId: Long,
    var guestId: Long?,
    var roomName: String,
    var roomNumber: String,
    var firstName: String?,
    var lastName: String?,
    var date: Date?
) {

    constructor(room: Room) : this(
        roomId = room.id,
        guestId = null,
        roomName = room.name,
        roomNumber = room.roomNumber,
        null,
        null,
        null
    )

    fun updateReservationDetails(reservation: Reservation?): RoomReservation {
        if (reservation == null) return this
        guestId = reservation.guestId
        date = reservation.reservationDate
        return this
    }

    fun updateGuestDetails(guest: Guest?): RoomReservation {
        if (guest == null) return this
        firstName = guest.firstName
        lastName = guest.lastName
        return this
    }

}

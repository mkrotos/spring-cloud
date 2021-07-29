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
}

class Room(
    var id: Long,
    var name: String,
    var roomNumber: String,
    var reservationDate: String,
)
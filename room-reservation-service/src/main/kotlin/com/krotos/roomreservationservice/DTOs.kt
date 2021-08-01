package com.krotos.roomreservationservice

import java.util.*

class Room(
    var id: Long,
    var name: String,
    var roomNumber: String,
    var reservationDate: String,
)

class Reservation(
    var id: Long,
    var roomId: Long,
    var guestId: Long,
    var reservationDate: Date,
)

class Guest(
    var id: Long,
    var firstName: String,
    var lastName: String,
    var email: String,
    var address: String,
    var country: String,
    var state: String,
    var phoneNumber: String
)
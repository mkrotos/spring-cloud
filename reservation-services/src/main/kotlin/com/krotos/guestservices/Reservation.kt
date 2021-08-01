package com.krotos.guestservices

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "RESERVATION")
class Reservation(
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    @Column(name = "ROOM_ID")
    var roomId: Long,
    @Column(name = "GUEST_ID")
    var guestId: Long,
    @Column(name = "RES_DATE")
    var reservationDate: Date,
)

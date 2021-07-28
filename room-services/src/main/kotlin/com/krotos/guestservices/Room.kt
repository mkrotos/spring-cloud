package com.krotos.guestservices

import javax.persistence.*

@Entity
@Table(name = "ROOM")
class Room(
    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    @Column(name = "NAME")
    var name: String,
    @Column(name = "ROOM_NUMBER")
    var roomNumber: String,
    @Column(name = "BED_INFO")
    var reservationDate: String,
)

package com.krotos.guestservices

import javax.persistence.*

@Entity
@Table(name = "GUEST")
class Guest(
    @Id
    @Column(name = "GUEST_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    @Column(name = "FIRST_NAME")
    var firstName: String,
    @Column(name = "LAST_NAME")
    var lastName: String,
    @Column(name = "EMAIL_ADDRESS")
    var email: String,
    @Column(name = "ADDRESS")
    var address: String,
    @Column(name = "COUNTRY")
    var country: String,
    @Column(name = "STATE")
    var state: String,
    @Column(name = "PHONE_NUMBER")
    var phoneNumber: String
)

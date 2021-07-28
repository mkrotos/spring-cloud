package com.krotos.guestservices

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class GuestServicesApplication

fun main(args: Array<String>) {
	runApplication<GuestServicesApplication>(*args)
}

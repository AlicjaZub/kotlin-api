package com.alicja.census

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CensusApplication

fun main(args: Array<String>) {
	runApplication<CensusApplication>(*args)
}

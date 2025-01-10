package com.alicja.census.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import com.alicja.census.domain.entities.CityEntity
import com.alicja.census.domain.dto.CityDto
import com.alicja.census.services.CityService
import com.alicja.census.toCityDto
import com.alicja.census.toCityEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
class CitiesController(private val cityService: CityService) {

    @PostMapping(path = ["v1/cities"])
    fun createCity(@RequestBody cityDto: CityDto): ResponseEntity<CityDto> {
        val createdCity = cityService.save(
            cityDto.toCityEntity()
        ).toCityDto()
        return ResponseEntity(createdCity, HttpStatus.CREATED)
    }

    @GetMapping(path = ["v1/health"])
    fun healthCheck(): String {
        return "Healthy :)"
    }
}

// The controller layer is the entry point for handling incoming HTTP requests.
// It defines RESTful endpoints and interacts with the service layer to process the requests.
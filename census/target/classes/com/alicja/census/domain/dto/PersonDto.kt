package com.alicja.census.domain.dto

import com.alicja.census.domain.dto.CityDto

data class PersonDto(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val city: CityDto
)

// curl -X POST http://localhost:8080/v1/cities \
// -H "Content-Type: application/json" \
// -d '{"name": "Los Angeles", "country": "US"}'

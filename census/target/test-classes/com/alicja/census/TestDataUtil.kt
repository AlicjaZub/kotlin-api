package com.alicja.census

import com.alicja.census.domain.dto.CityDto
import com.alicja.census.domain.entities.CityEntity

fun testCityDtoA(id: Long? = null) = 
 CityDto(
    id=id,
    name="Los Angeles",
    country="US"
)


fun testCityEntityA(id: Long? = null) = 
 CityEntity(
    id=id,
    name="Los Angeles",
    country="US"
)
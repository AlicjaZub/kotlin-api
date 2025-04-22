package com.alicja.census

import com.alicja.census.domain.dto.CityDto
import com.alicja.census.domain.entities.CityEntity

fun CityEntity.toCityDto() = CityDto(
    id = this.id,
    name = this.name,
    country = this.country
)

fun CityDto.toCityEntity() = CityEntity(
    id = this.id,
    name = this.name,
    country = this.country
)
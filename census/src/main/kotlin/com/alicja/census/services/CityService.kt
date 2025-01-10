package com.alicja.census.services

import com.alicja.census.domain.entities.CityEntity

interface CityService {
    fun save(cityEntity: CityEntity): CityEntity
}
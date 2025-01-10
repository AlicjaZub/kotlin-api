package com.alicja.census.services.impl

import com.alicja.census.domain.entities.CityEntity
import com.alicja.census.repositories.CityRepository
import com.alicja.census.services.CityService
import org.springframework.stereotype.Service

@Service
class CityServiceImpl(private val cityRepository: CityRepository): CityService {
    override fun save(cityEntity: CityEntity): CityEntity {
        return cityRepository.save(cityEntity)
    }
}
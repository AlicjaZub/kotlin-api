package com.alicja.census.repositories

import com.alicja.census.domain.entities.CityEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository : JpaRepository<CityEntity,Long>
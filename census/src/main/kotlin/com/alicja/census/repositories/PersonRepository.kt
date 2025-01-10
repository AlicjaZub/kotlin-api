package com.alicja.census.repositories

import com.alicja.census.domain.entities.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<PersonEntity,Long>
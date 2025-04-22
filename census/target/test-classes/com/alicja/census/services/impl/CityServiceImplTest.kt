package com.alicja.census.services.impl

import com.alicja.census.repositories.CityRepository
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.beans.factory.annotation.Autowired
import com.alicja.census.testCityEntityA
import org.springframework.data.repository.findByIdOrNull
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class CityServiceImplTest@Autowired constructor(private val underTest: CityServiceImpl, private val cityRepository: CityRepository) {

    @Test
    fun `test that save persists the City in the database`() {
        val savedCity = underTest.save(testCityEntityA())
        assertThat(savedCity.id).isNotNull()

        val recalledCity = cityRepository.findByIdOrNull(savedCity.id!!)
        assertThat(recalledCity).isNotNull()
        assertThat(recalledCity!!).isEqualTo(testCityEntityA(id=savedCity.id))
    }
    
}
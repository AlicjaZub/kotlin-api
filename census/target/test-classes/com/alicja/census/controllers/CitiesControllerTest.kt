package com.alicja.census.controllers

import com.alicja.census.domain.dto.CityDto
import com.alicja.census.domain.entities.CityEntity
import com.alicja.census.services.CityService
import com.fasterxml.jackson.databind.ObjectMapper
import com.alicja.census.testCityDtoA
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.get

private const val CITIES_BASE_URL = "/v1/cities"

@SpringBootTest
@AutoConfigureMockMvc
class CitiesControllerTest @Autowired constructor(private val mockMvc: MockMvc, @MockkBean val cityService: CityService) {

    val objectMapper = ObjectMapper()

    @BeforeEach
    fun beforeEach() {
        every { cityService.save(any()) } answers { firstArg() }
    }

    @Test
    fun `test that list return and empty list and HTTP 200 when no cities`() {
        every {
            cityService.list()
        } answers {
            emptyList()
        }
        mockMvc.get(CITIES_BASE_URL) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { json("[]") }
        }
    }

    @Test
    fun `test that creates City saves the City`() {

        mockMvc.post(CITIES_BASE_URL) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content =
                objectMapper.writeValueAsString(
                   testCityDtoA() 
                )
        }

        val expected =
            CityEntity(
                id = null,
                name="Los Angeles",
                country="US"
            )

        verify{ cityService.save(expected) }
    }


    @Test
    fun `test that creates City returns a HTTP 201 status on a successful create`() {
        mockMvc.post(CITIES_BASE_URL) {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content =
                objectMapper.writeValueAsString(
                        testCityDtoA() 
                )
        }.andExpect {
            status { isCreated() }
        }
    }


}

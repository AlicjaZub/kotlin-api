package com.alicja.census.controllers

import com.alicja.census.domain.dto.CityDto
import com.alicja.census.domain.entities.CityEntity
import com.alicja.census.services.CityService
import com.fasterxml.jackson.databind.ObjectMapper
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



@SpringBootTest
@AutoConfigureMockMvc
class CitiesControllerTest @Autowired constructor(private val mockMvc: MockMvc, @MockkBean val cityService: CityService) {

    val objectMapper = ObjectMapper()

    @BeforeEach
    fun beforeEach() {
        every { cityService.save(any()) } answers { firstArg() }
    }

    @Test
    fun `test that creates City saves the City`() {

        mockMvc.post("/v1/cities") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content =
                objectMapper.writeValueAsString(
                    CityDto(
                        id = null,
                        name = "Doe",
                        country = "Albania"
                    )
                )
        }

        val expected =
            CityEntity(
                id = null,
                name = "Doe",
                country = "Albania"
            )

        verify{ cityService.save(expected) }
    }


    @Test
    fun `test that creates City returns a HTTP 201 status on a successful create`() {
        mockMvc.post("/v1/cities") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content =
                objectMapper.writeValueAsString(
                        CityDto(
                            id = null,
                            name = "Berlin",
                            country = "Germany"
                        )
                )
        }.andExpect {
            status { isCreated() }
        }
    }
}

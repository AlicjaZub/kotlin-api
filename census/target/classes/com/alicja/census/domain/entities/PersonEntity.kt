package com.alicja.census.domain.entities

import jakarta.persistence.*
import com.alicja.census.domain.entities.CityEntity

@Entity
@Table(name="persons")
data class PersonEntity(
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
    val id: Long?,

    @Column(name="firstName")
    val firstName: String,

    @Column(name="lastName")
    val lastName: String,

    @ManyToOne(cascade = [CascadeType.DETACH])
    @JoinColumn(name="city_id")
    val city: CityEntity
)


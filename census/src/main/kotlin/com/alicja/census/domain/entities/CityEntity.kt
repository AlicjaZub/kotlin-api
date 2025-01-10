package com.alicja.census.domain.entities

import jakarta.persistence.*

@Entity
@Table(name="cities")
data class CityEntity(
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_id_seq")
    val id: Long?,

    @Column(name="name") 
    val name: String,
    
    @Column(name="country")
    val country: String)

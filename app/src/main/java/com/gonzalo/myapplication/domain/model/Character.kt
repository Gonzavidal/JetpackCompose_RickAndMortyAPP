package com.gonzalo.myapplication.domain.model


data class Character (
    val id: Int,
    val name: String,
    val status: String,
    val specie: String,
    val gender: String,
    val origin: com.gonzalo.myapplication.data.source.remote.dto.Origin,
    val location: com.gonzalo.myapplication.data.source.remote.dto.Location,
    val image: String
)
package com.gonzalo.myapplication.data.source.remote.dto

import com.gonzalo.myapplication.domain.model.Characters

data class CharactersDto(
    val info: Info,
    val results: List<Result<Any?>>
)

fun CharactersDto.toListCharacters(): List<Characters> {
    val resultEntries = results.mapIndexed { _, entries ->
        Characters(
            id = entries.id,
            name = entries.name,
            specie = entries.species,
            image = entries.image
        )
    }
    return resultEntries
}
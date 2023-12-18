package com.gonzalo.myapplication.domain.repositories

import com.gonzalo.myapplication.data.source.remote.dto.Result
import com.gonzalo.myapplication.domain.model.Character
import com.gonzalo.myapplication.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters(page: Int): Flow<com.gonzalo.myapplication.data.Result<List<Characters>>>

    suspend fun getCharacter(id: Int): com.gonzalo.myapplication.data.Result<Character>
}
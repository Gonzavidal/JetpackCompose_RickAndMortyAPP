package com.gonzalo.myapplication.domain.repositories

import com.gonzalo.myapplication.data.Result
import com.gonzalo.myapplication.domain.model.Character
import com.gonzalo.myapplication.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getCharacters(page: Int): Flow<Result<List<Characters>>>

    suspend fun getCharacter(id: Int): Result<Character>
}
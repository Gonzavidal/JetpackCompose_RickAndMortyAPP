package com.gonzalo.myapplication.domain.use_case

import com.gonzalo.myapplication.data.Result
import com.gonzalo.myapplication.domain.model.Character
import com.gonzalo.myapplication.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int): Result<Character> {
        return repository.getCharacter(id)
    }
}
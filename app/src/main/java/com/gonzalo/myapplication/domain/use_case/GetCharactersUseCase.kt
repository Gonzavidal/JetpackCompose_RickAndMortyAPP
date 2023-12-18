package com.gonzalo.myapplication.domain.use_case

import com.gonzalo.myapplication.data.Result
import com.gonzalo.myapplication.domain.model.Characters
import com.gonzalo.myapplication.domain.repositories.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(page: Int): Flow<Result<List<Characters>>> {
        return repository.getCharacters(page)
    }
}
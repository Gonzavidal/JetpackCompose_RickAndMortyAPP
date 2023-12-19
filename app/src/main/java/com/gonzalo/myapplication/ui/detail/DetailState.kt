package com.gonzalo.myapplication.ui.detail

import com.gonzalo.myapplication.domain.model.Character

data class DetailState(
    val character: Character? = null,
    val isLoading: Boolean = false
)
package com.gonzalo.myapplication.ui.home

import com.gonzalo.myapplication.domain.model.Characters

data class HomeState(
    val characters: List<Characters> = emptyList(),
    val showPrevious: Boolean = false,
    val showNext: Boolean = false,
    val isLoading: Boolean = false

)

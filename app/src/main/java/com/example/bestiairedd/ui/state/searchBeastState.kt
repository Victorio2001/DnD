package com.example.bestiairedd.ui.state

import com.example.bestiairedd.domain.model.beast.BeastShow

sealed class SearchBeastState {
    data object Loading : SearchBeastState()
    data object Empty : SearchBeastState()
    data class Loaded(val beasts: List<BeastShow>) : SearchBeastState()
    data class Error(val message: String) : SearchBeastState()
}

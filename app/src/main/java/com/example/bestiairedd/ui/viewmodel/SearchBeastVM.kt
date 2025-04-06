package com.example.bestiairedd.ui.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestiairedd.domain.repository.beast.BeastRepository
import com.example.bestiairedd.domain.repository.beast.IBeastRepository
import com.example.bestiairedd.ui.state.SearchBeastState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchBeastVM (
    //!  Par défaut, on met NetworkMovieRepository
    private val IbeastRepository: IBeastRepository = BeastRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<SearchBeastState>(SearchBeastState.Empty)
    val uiState: StateFlow<SearchBeastState> get() = _uiState

    fun searchMovie(text: String) {

        // ? mode "Loading"
        _uiState.value = SearchBeastState.Loading

        // ! coroutine
        // ! coroutine
        // ! coroutine
        viewModelScope.launch {

            val beasts = IbeastRepository.searchBeast(text)

            if (beasts.isEmpty()) {
                _uiState.value = SearchBeastState.Empty
            } else {
                _uiState.value = SearchBeastState.Loaded(beasts)
            }
        }
    }

}
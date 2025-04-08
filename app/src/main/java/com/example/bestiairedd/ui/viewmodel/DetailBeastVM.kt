package com.example.bestiairedd.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestiairedd.domain.model.beast.BeastShow
import com.example.bestiairedd.domain.model.beast.BeastShowMore
import com.example.bestiairedd.domain.repository.beast.BeastRepository
import com.example.bestiairedd.domain.repository.beast.IBeastRepository
import com.example.bestiairedd.ui.state.ShowBeastState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailBeastVM(
    private val repository: IBeastRepository = BeastRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<ShowBeastState>(ShowBeastState.Loading)
    val uiState: StateFlow<ShowBeastState> = _uiState

    fun loadBeastDetail(index: String) {
        _uiState.value = ShowBeastState.Loading
        viewModelScope.launch {
            val result: BeastShowMore? = repository.getBeastDetailById(index)
            if (result != null) {
                _uiState.value = ShowBeastState.Loaded(result)
            } else {
                _uiState.value = ShowBeastState.Error("Aucun détail trouvé ou erreur réseau.")
            }
        }
    }
}
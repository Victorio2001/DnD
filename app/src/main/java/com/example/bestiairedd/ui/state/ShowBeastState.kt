package com.example.bestiairedd.ui.state

import com.example.bestiairedd.domain.model.beast.BeastShow
import com.example.bestiairedd.domain.model.beast.BeastShowMore

sealed class ShowBeastState {
    data object Loading : ShowBeastState()

    data class Loaded(val beasts: BeastShowMore) : ShowBeastState()
    data class Error(val message: String) : ShowBeastState()
}

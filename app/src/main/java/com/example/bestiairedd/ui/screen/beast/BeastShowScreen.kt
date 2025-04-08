package com.example.bestiairedd.ui.screen.beast

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bestiairedd.ui.component.beast.BeastShow
import com.example.bestiairedd.ui.state.ShowBeastState
import com.example.bestiairedd.ui.viewmodel.DetailBeastVM


@Composable
fun BeastDetailScreen(
    index: String,
    detailViewModel: DetailBeastVM = viewModel(),
    //favorisViewModel: DataModelFavorisViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    LaunchedEffect(index) {
        detailViewModel.loadBeastDetail(index)
    }

    val uiState by detailViewModel.uiState.collectAsState()

    when (val state = uiState) {
        is ShowBeastState.Loading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is ShowBeastState.Error -> {
            Text(
                text = "Erreur : ${state.message}",
                modifier = modifier.fillMaxSize()
            )
        }

        is ShowBeastState.Loaded -> {
            BeastShow(
                beast = state.beasts,
                /*onAddToFavorites = { movieDetail ->
                    favorisViewModel.addData(movieDetail)
                },*/
                modifier = modifier
            )
        }
    }
}
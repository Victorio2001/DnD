package com.example.bestiairedd.ui.screen.beast


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bestiairedd.domain.model.beast.BeastShowAll
import com.example.bestiairedd.ui.component.beast.BeastAll
import com.example.bestiairedd.ui.component.search.SearchHeader
import com.example.bestiairedd.ui.state.SearchBeastState
import com.example.bestiairedd.ui.viewmodel.SearchBeastVM


@Composable
fun SearchBeastScreen(
    onNavigateToDetail: (String) -> Unit,
    onNavigateToFavorites: () -> Unit = {},
    searchViewModel: SearchBeastVM = viewModel(),
    modifier: Modifier = Modifier
) {
    val viewModelState by searchViewModel.uiState.collectAsState()

    Column(modifier.fillMaxSize()) {


        SearchHeader(
            onSearchClick = { userQuery ->
                searchViewModel.searchMovie(userQuery)
            }
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = { onNavigateToFavorites() }
            ) {
                Text("Voir Favoris")
            }
        }


        when (val state = viewModelState) {
            is SearchBeastState.Empty -> {
                Text(
                    text = "Aucun résultat ou aucune recherche effectuée",
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }

            is SearchBeastState.Error -> {
                Text(
                    text = "Erreur : ${state.message}",
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }

            is SearchBeastState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                ) {
                    CircularProgressIndicator()
                }
            }


            is SearchBeastState.Loaded -> {
                BeastAll(
                    Beasts = state.beasts,
                    onMovieClick = { imdbId ->
                        onNavigateToDetail(imdbId)
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
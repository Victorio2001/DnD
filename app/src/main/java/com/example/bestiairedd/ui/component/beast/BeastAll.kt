package com.example.bestiairedd.ui.component.beast

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.tooling.preview.Preview
import com.example.bestiairedd.domain.model.beast.BeastShow


@Composable
fun BeastAll(
    Beasts: List<BeastShow>,
    onMovieClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    // ! LazyColumn permet d’afficher de graandes listes
    LazyColumn(
        state = listState,
        modifier = modifier
    ) {
        items(Beasts) { beast ->
            BeastItem(
                beast = beast,
                onClick = {
                    onMovieClick(beast.index)
                }
            )
            Divider(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BeastAllPreview() {

    val sampleBeasts = remember {
        listOf(
            BeastShow(name = "Dragon 1", url = "http://www.dnd5eapi.co/api/2014/images/monsters/adult-black-dragon.png", index = "Dragon"),
            BeastShow(name = "Dragon 2", url = "http://www.dnd5eapi.co/api/2014/images/monsters/adult-black-dragon.png", index = "Dragon"),
            BeastShow(name = "Dragon 3", url = "http://www.dnd5eapi.co/api/2014/images/monsters/adult-black-dragon.png", index = "Dragon")
        )
    }

    BeastAll(Beasts = sampleBeasts)
}


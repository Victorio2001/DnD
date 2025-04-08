package com.example.bestiairedd.ui.component.beast

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bestiairedd.domain.model.beast.BeastShowMore


@Composable
fun BeastShow(beast: BeastShowMore, modifier: Modifier = Modifier, onAddToFavorites: (BeastShowMore) -> Unit = {},) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        shape = RectangleShape, // ? ou RoundedCornerShape(8.dp)
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = beast.name, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))


            Text(text = "Taille : ${beast.size}")
            Text(text = "Type : ${beast.type}")
            Text(text = "Alignement: ${beast.alignment}")


            /*androidx.compose.material3.Button(
                onClick = {
                    onAddToFavorites(movie)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Enrengistrer")
            }*/

            AsyncImage(
                model = "https://www.dnd5eapi.co" + beast.image,
                contentDescription = beast.name,
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight()
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}
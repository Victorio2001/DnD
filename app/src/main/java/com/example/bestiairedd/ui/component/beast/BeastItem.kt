package com.example.bestiairedd.ui.component.beast

import com.example.bestiairedd.domain.model.beast.BeastShow
import com.example.bestiairedd.domain.model.beast.BeastShowAll


import android.util.Log
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter


@Composable
fun BeastItem(
    beast: BeastShow,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RectangleShape, // ? ou RoundedCornerShape(8.dp)
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            AsyncImage(
                model = "https://www.dnd5eapi.co" + beast.url,
                contentDescription = "Poster of ${beast.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.666f),
                placeholder = rememberAsyncImagePainter("https://via.placeholder.com/150")
            )

            Text(
                text = beast.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BeastItemPreview() {
    BeastItem(
        // ! je lui passe un objet de test
        BeastShow(name = "Dragon", url = "http://www.dnd5eapi.co/api/2014/images/monsters/adult-black-dragon.png", index = "Dragon")
    )
}
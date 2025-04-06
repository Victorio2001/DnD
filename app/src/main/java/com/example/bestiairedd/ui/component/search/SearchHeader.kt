package com.example.bestiairedd.ui.component.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchHeader(
    modifier: Modifier = Modifier,
    onSearchClick: (String) -> Unit = {}
) {
    // ? État local pour stocker le texte tapé dans la barre de recherche
    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { newValue -> text = newValue },
            label = { Text("Rechercher un Monstre") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            onClick = { onSearchClick(text) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Rechercher")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SearchHeaderPreview() {
    SearchHeader()
}



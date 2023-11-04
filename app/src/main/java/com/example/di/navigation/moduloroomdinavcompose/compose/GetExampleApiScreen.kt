package com.example.di.navigation.moduloroomdinavcompose.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.di.navigation.moduloroomdinavcompose.api.practiceget.dto.AnimeList
import com.example.di.navigation.moduloroomdinavcompose.api.practiceget.dto.AnimeResult
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader.dto.VersionsList
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader.dto.VersionsResult


@Composable
internal fun GetExampleApiScreen(uiState: AnimeList?, onLoad: () -> Unit,
                              onNavigateTo: (conversationId: String) -> Unit= {}
) {

    LazyColumn{
        item {
            Button(onClick = { onLoad() }) {
                Text(text = "ExampleGetApi. OnLoad with ViewModel ")
            }
        }

        items(uiState!!.data){ item: AnimeResult ->
            Text(text = "Titulo: " + item.title)
            Text(text = "url: " + item.url)
            Divider()
        }




    }

}



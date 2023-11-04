package com.example.di.navigation.moduloroomdinavcompose.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.di.navigation.moduloroomdinavcompose.api.exampleclass.dto.QuoteList
import com.example.di.navigation.moduloroomdinavcompose.api.exampleclass.dto.Result


@Composable
internal fun ElevenApiScreen(uiState: QuoteList?, onLoad: () -> Unit,
                             onNavigateTo: (conversationId: String) -> Unit= {}
) {

    LazyColumn{
        item{
            Button(onClick = { onLoad() }) {
                Text(text = "ElevenApiScreen. OnLoad with ViewModel ")
            }
        }
        
        items(uiState!!.results){ item: Result ->
            Text(text = item.author)
        }
        
    }

}
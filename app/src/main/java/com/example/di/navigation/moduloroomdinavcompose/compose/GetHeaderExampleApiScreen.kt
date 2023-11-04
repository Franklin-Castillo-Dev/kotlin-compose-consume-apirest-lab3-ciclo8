package com.example.di.navigation.moduloroomdinavcompose.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader.dto.VersionsList
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader.dto.VersionsResult


@Composable
internal fun ExampleApiScreen(
    uiState: VersionsList, onLoad: () -> Unit,
    onNavigateTo: (conversationId: String) -> Unit= {}
) {

    LazyColumn{
        item {
            Button(onClick = { onLoad() }) {
                Text(text = "ExampleGetApiWithHeader. OnLoad with ViewModel ")
            }
        }

        items(uiState!!.alternateTitles){ item: VersionsResult ->
            Text(text = item.title)
        }




    }

}



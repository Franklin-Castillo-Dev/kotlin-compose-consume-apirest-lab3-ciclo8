package com.example.di.navigation.moduloroomdinavcompose.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetarray.dto.ShibeList


@Composable
internal fun GetArrayExampleApiScreen(uiState: ShibeList?, onLoad: () -> Unit,
                                       onNavigateTo: (conversationId: String) -> Unit= {}
) {

    LazyColumn{
        item {
            Button(onClick = { onLoad() }) {
                Text(text = "ExampleGetArrayApi. OnLoad with ViewModel ")
            }
        }

        items(uiState!!.imageShibeUrl){ imageShibeUrl ->
            Text(text = "Titulo: " + imageShibeUrl)

            ImageFromUrlCoil(imageShibeUrl)
            Divider()
        }



    }

}

@Composable
fun ImageFromUrlCoil(url: String) {
    Box {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .build(),
            contentDescription = "Imagen",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp, 80.dp)
                .clip(CircleShape)
        )

    }
}

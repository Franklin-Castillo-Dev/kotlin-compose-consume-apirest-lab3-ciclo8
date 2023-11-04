package com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ImdbRetrofitHelper {

    val baseUrl = "https://imdb8.p.rapidapi.com"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}
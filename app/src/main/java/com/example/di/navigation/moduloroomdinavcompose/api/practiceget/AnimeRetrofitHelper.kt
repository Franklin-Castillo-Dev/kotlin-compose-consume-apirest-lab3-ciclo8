package com.example.di.navigation.moduloroomdinavcompose.api.practiceget

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AnimeRetrofitHelper {

    val baseUrl = "https://api.jikan.moe"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }

}
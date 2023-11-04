package com.example.di.navigation.moduloroomdinavcompose.api.practicegetsimple

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JokeRetrofitHelper {

    val baseUrl = "https://official-joke-api.appspot.com/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }

}
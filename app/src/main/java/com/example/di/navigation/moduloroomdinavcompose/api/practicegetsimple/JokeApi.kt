package com.example.di.navigation.moduloroomdinavcompose.api.practicegetsimple

import com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader.dto.VersionsList
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetsimple.dto.JokeList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface JokeApi {

    @GET("/random_joke")
    suspend fun getJoke() : Response<JokeList>
}
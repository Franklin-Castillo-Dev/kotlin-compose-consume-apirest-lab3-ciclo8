package com.example.di.navigation.moduloroomdinavcompose.api.practicegetarray

import com.example.di.navigation.moduloroomdinavcompose.api.practiceget.dto.AnimeList
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetarray.dto.ShibeList
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ShibeApi {

    @GET("/api/shibes?count=4")
    suspend fun getShibe(
    ) : ResponseBody
}
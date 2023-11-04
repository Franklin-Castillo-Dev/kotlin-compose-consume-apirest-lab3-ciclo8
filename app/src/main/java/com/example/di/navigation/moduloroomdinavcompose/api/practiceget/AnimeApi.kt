package com.example.di.navigation.moduloroomdinavcompose.api.practiceget

import com.example.di.navigation.moduloroomdinavcompose.api.practiceget.dto.AnimeList
import com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader.dto.VersionsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface AnimeApi {

    @GET("/v4/anime?q=naruto")
    suspend fun getNaruto(
    ) : Response<AnimeList>
}
package com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader

import com.example.di.navigation.moduloroomdinavcompose.api.practicegetheader.dto.VersionsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ImdbApi {

    @GET("/title/get-versions?tconst=tt0944947")
    suspend fun getVersions(
        @Header("X-RapidAPI-Key") apiKey: String,
        @Header("X-RapidAPI-Host") apiHost: String
    ) : Response<VersionsList>



}
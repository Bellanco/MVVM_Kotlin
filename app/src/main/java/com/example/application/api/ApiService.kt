package com.example.application.api

import com.example.application.model.CharactersResponseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/api/character")
    suspend fun getAllCharacters(
    ): Response<CharactersResponseModel>

}


package com.deromang.rick.api

import com.deromang.rick.model.CharactersResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/api/character")
    suspend fun getAllCharacters(
    ): Response<CharactersResponseModel>

}


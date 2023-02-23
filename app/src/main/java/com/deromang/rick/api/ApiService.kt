package com.deromang.rick.api

import com.deromang.rick.model.CharactersResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/character")
    suspend fun getCharacters(
        @Query("name") text: String?,
        @Query("status") status: String?
    ): Response<CharactersResponseModel>

}


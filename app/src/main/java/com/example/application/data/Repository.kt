package com.example.application.data

import com.example.application.api.ApiGenerator
import com.example.application.model.CharactersResponseModel
import retrofit2.Response

class Repository {


    suspend fun getCharacters(): Response<CharactersResponseModel> =
        ApiGenerator.createService().getAllCharacters()

}
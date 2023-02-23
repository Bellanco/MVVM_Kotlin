package com.deromang.rick.data

import com.deromang.rick.api.ApiGenerator
import com.deromang.rick.model.CharactersResponseModel
import retrofit2.Response

class Repository {
    suspend fun getCharacters(text: String?, state: String?): Response<CharactersResponseModel> =
        ApiGenerator.createService().getCharacters(text, state)


}
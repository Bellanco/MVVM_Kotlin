package com.example.application.ui.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application.data.Repository
import com.example.application.data.Result
import com.example.application.model.CharactersResponseModel
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {

    private val _getCharacterResult = MutableLiveData<Result<CharactersResponseModel>>()
    val getCharacterResult: LiveData<Result<CharactersResponseModel>> = _getCharacterResult

    fun getCharacters() {

        val repository = Repository()

        viewModelScope.launch {
            val responseModel = repository.getCharacters()

            _getCharacterResult.value = Result(success = responseModel.body())
        }
    }

}
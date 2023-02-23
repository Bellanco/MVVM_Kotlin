package com.deromang.rick.ui.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deromang.rick.data.Repository
import com.deromang.rick.data.Result
import com.deromang.rick.model.CharactersResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {

    private val _getCharacterResult = MutableLiveData<Result<CharactersResponseModel>>()
    val getCharacterResult: LiveData<Result<CharactersResponseModel>> = _getCharacterResult

    fun getCharacters() {

        val repository = Repository()

        viewModelScope.launch(Dispatchers.IO) {

            val responseModel = repository.getCharacters()

            _getCharacterResult.postValue(Result(success = responseModel.body()))
        }
    }

}
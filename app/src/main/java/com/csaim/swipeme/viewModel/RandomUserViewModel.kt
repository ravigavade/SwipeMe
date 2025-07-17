package com.csaim.swipeme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csaim.swipeme.data.model.Results
import com.csaim.swipeme.data.repository.RandomUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RandomUserViewModel:ViewModel() {

    val repository = RandomUserRepository()

    private val _randomUser = MutableStateFlow<Results?>(null)
    val randomUser: Flow<Results?> = _randomUser

    fun fetchUser(){
        viewModelScope.launch {
            try {
                val response = repository.getAUser()
                _randomUser.value = response.results.first()
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

}
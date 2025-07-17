package com.csaim.swipeme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csaim.swipeme.data.model.Results
import com.csaim.swipeme.data.model.UserResponse
import com.csaim.swipeme.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {

    val respository = UserRepository()

    private val _user = MutableStateFlow<Results?>(null)
    val user : Flow<Results?> = _user

    fun fetchUser(){
        viewModelScope.launch {
            try {
                val response = respository.getRandomUser()
                _user.value = response.first()
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }


}
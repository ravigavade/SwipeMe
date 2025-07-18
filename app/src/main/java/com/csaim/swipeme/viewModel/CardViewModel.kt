package com.csaim.swipeme.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csaim.swipeme.data.model.DogResponse
import com.csaim.swipeme.data.model.Results
import com.csaim.swipeme.data.repository.DogRepository
import com.csaim.swipeme.data.repository.UserRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CardViewModel:ViewModel() {

    val userRespository = UserRepository()
    val dogRepository = DogRepository()

    private val _user = MutableStateFlow<Results?>(null)
    val user : StateFlow<Results?> = _user

    private val _dog = MutableStateFlow<DogResponse?>(null)
    val dog : StateFlow<DogResponse?> = _dog

    fun fetchCard(){
        viewModelScope.launch {
            try {
                val dogResponse =async { dogRepository.getRandomDog()}
                val userResponse = async {   userRespository.getRandomUser()}

                _user.value = userResponse.await().first()
                _dog.value = dogResponse.await()

            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }


}
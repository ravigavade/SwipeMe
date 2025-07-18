package com.csaim.swipeme.data.repository

import com.csaim.swipeme.data.model.DogResponse
import com.csaim.swipeme.data.remote.DogApi
import com.csaim.swipeme.data.remote.DogServiceApi

class DogRepository {

    suspend fun getRandomDog(): DogResponse {
        return DogApi.dogServiceApi.getDog()
    }

}
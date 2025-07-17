package com.csaim.swipeme.data.repository

import com.csaim.swipeme.data.model.RandomUserResponse
import com.csaim.swipeme.data.remote.RandomUserApi

class RandomUserRepository {

    suspend fun getAUser(): RandomUserResponse{
        return RandomUserApi.randomUserServiceApi.getRandomUser()
    }


}
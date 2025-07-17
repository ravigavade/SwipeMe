package com.csaim.swipeme.data.repository

import com.csaim.swipeme.data.model.Results
import com.csaim.swipeme.data.model.UserResponse
import com.csaim.swipeme.data.remote.UserApi

class UserRepository {

    suspend fun getRandomUser(): List<Results>{
        return UserApi.userServiceApi.getUser().results
    }

}
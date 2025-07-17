package com.csaim.swipeme.data.remote

import com.csaim.swipeme.data.model.UserResponse
import retrofit2.http.GET

interface UserServiceApi {

    @GET("api")
    suspend fun getUser(): UserResponse

}
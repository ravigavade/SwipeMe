package com.csaim.swipeme.data.remote

import com.csaim.swipeme.data.model.RandomUserResponse
import retrofit2.http.GET

interface RandomUserServiceApi {

    @GET("api")
    suspend fun getRandomUser(): RandomUserResponse

}
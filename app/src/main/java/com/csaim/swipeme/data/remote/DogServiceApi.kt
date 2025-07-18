package com.csaim.swipeme.data.remote

import com.csaim.swipeme.data.model.DogResponse
import retrofit2.http.GET

interface DogServiceApi {


    @GET("breeds/image/random")
    suspend fun getDog():DogResponse

}
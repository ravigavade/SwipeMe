package com.csaim.swipeme.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogApi {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}
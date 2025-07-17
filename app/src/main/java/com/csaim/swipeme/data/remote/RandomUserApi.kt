package com.csaim.swipeme.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RandomUserApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val randomUserServiceApi = retrofit.create(RandomUserServiceApi::class.java)
}
package com.csaim.swipeme.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserApi {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userServiceApi = retrofit.create(UserServiceApi::class.java)

}
package com.csaim.swipeme.data.model

data class RandomUserResponse(
    val results: List<Results>
)

data class Results(
    val gender: String,
    val name: Name,
    val email: String,
    val picture: Picture

)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Picture(
    val large: String
)
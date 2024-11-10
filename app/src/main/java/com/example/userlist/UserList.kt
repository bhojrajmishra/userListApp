package com.example.userlist

import com.google.gson.annotations.SerializedName

// 1- Data Classes (POJO)
data class UserList(
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("avatar")
    val avatar: String
)

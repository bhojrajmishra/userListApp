package com.example.userlist.model

import com.google.gson.annotations.SerializedName

data class UserList(
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("avatar")
    val avatar: String
) {
    // Override toString to display user information in ListView
    override fun toString(): String {
        return "$firstName $lastName\n$email"
    }
}
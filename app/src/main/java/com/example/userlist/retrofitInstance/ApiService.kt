package com.example.userlist.retrofitInstance

import com.example.userlist.model.UsersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users?page=2")  // Removed typo 'p' from URL
    suspend fun getUsers(): Response<UsersResponse>
}
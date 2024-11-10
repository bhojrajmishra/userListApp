package com.example.userlist.retrofitInstance

import com.example.userlist.UserListAlbum
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users?page=2p")
    suspend fun getSpecificAlbums(@Query("userId") userId:Int)  : Result<UserListAlbum>
}
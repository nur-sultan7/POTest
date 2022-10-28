package com.example.potest.data.network


import com.example.potest.data.network.model.AuthDataDto
import com.example.potest.data.network.model.ProfileDto
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import java.util.*


interface ApiService {

    @POST("auth")
    fun authUser(
        @Body body: JsonObject
    ): Call<AuthDataDto>

    @GET("profile")
    fun getProfile(
        @Header("Authorization") token: String
    ): Call<ProfileDto>

}
package com.example.potest.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class AuthDataDto(
    @SerializedName("token")
    @Expose
    val token: String
) {
    fun getBearerToken(): String = BEARER_HEADER.plus(token)

    companion object {
        private const val BEARER_HEADER = "Bearer "
    }
}


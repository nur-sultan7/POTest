package com.example.potest.domain

import com.example.potest.domain.entity.Profile

interface Repository {
    suspend fun authUser(email: String, password: String): String?
    suspend fun loadProfile(): String?
    suspend fun getProfile(): Profile
}
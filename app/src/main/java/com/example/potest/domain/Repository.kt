package com.example.potest.domain

import com.example.potest.domain.entity.Profile

interface Repository {
    suspend fun authUser(email: String, password: String): String?
    suspend fun getProfile(id: String): Profile
}
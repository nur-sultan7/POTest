package com.example.potest.domain

interface Repository {
    suspend fun authUser(email: String, password: String): Boolean
}
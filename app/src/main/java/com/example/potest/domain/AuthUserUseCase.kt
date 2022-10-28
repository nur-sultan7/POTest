package com.example.potest.domain

class AuthUserUseCase(private val repository: Repository) {
    suspend operator fun invoke(email: String, password: String): Boolean {
        return repository.authUser(email, password)
    }
}
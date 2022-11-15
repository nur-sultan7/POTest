package com.example.potest.domain

import javax.inject.Inject

class AuthUserUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(email: String, password: String): String? {
        return repository.authUser(email, password)
    }
}
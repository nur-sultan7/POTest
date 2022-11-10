package com.example.potest.domain

class LoadProfileUseCase(private val repository: Repository) {
    suspend operator fun invoke(): String? {
        return repository.loadProfile()
    }
}
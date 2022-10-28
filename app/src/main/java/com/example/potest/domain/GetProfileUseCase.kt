package com.example.potest.domain

import com.example.potest.domain.entity.Profile

class GetProfileUseCase(private val repository: Repository) {
    suspend operator fun invoke(id: String): Profile {
        return repository.getProfile(id)
    }
}
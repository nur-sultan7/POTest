package com.example.potest.domain

import javax.inject.Inject

class LoadProfileUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): String? {
        return repository.loadProfile()
    }
}
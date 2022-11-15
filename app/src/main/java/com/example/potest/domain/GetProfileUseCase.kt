package com.example.potest.domain

import com.example.potest.domain.entity.Profile
import javax.inject.Inject

class GetProfileUseCase @Inject constructor (private val repository: Repository) {
    suspend operator fun invoke(): Profile {
        return repository.getProfile()
    }
}
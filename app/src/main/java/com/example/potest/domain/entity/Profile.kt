package com.example.potest.domain.entity

data class Profile(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val avatar: String,
    val companyName: String,
    val sections: String,
)
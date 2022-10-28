package com.example.potest.data

import com.example.potest.data.database.model.ProfileModel
import com.example.potest.data.network.model.ProfileDto
import com.google.gson.JsonObject

class Mapper {
    fun getJsonBody(email: String, password: String): JsonObject {
        return JsonObject().apply {
            addProperty("email", email)
            addProperty("password", password)
        }
    }

    fun mapProfileDtoTOModel(dto: ProfileDto): ProfileModel {
        return ProfileModel(
            id = dto.id,
            name = dto.name,
            email = dto.email,
            phone = dto.phone,
            avatar = dto.avatar,
            position = dto.position,
            companyName = dto.companyName,
            nameEng = dto.nameEng,
            timezone = dto.timezone,
            sections = dto.sections.toString(),
            alertEmail = dto.alertEmail,
            sendSystemNotifications = dto.sendSystemNotifications
        )
    }
}
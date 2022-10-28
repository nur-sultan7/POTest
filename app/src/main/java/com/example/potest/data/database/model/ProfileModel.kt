package com.example.potest.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "profile_table")
open class ProfileModel(
    @PrimaryKey
    var id: String,
    var name: String,
    var email: String,
    var phone: String,
    var avatar: String,
    var position: String,
    var companyName: String,
    var nameEng: String,
    var timezone: String,
    var sections: String,
    var alertEmail: String,
    var sendSystemNotifications: Boolean
)

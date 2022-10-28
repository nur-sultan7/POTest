package com.example.potest.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ProfileDto(
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("phone")
    @Expose
    var phone: String,


    @SerializedName("avatar")
    @Expose
    var avatar: String,


    @SerializedName("position")
    @Expose
    var position: String,


    @SerializedName("company_name")
    @Expose
    var companyName: String,


    @SerializedName("name_eng")
    @Expose
    var nameEng: String,


    @SerializedName("timezone")
    @Expose
    var timezone: String,


    @SerializedName("sections")
    @Expose
    var sections: List<String>,


    @SerializedName("alert_email")
    @Expose
    var alertEmail: String,


    @SerializedName("send_system_notifications")
    @Expose
    var sendSystemNotifications: Boolean
)

package com.example.potest.data

import android.content.Context
import android.content.SharedPreferences
import com.example.potest.R
import javax.inject.Inject

class SessionManager @Inject constructor(context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )

    fun saveUserId(id: String) {
        val editor = prefs.edit()
        editor.putString(USER_ID, id)
        editor.apply()
    }

    fun fetchUserId(): String {
        return prefs.getString(USER_ID, null) ?: EMPTY_STRING
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun fetchAuthToken(): String {
        return prefs.getString(USER_TOKEN, null) ?: EMPTY_STRING
    }

    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_ID = "user_id"
        const val EMPTY_STRING = ""
    }

}
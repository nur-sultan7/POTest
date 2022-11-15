package com.example.potest.presentation

import android.app.Application
import com.example.potest.di.DaggerApplicationComponent

class POTestApp : Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}
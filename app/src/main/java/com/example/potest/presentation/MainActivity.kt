package com.example.potest.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.potest.R
import com.example.potest.di.ContextModule
import com.example.potest.di.DaggerApplicationComponent

class MainActivity : AppCompatActivity() {
    private val component by lazy {
        DaggerApplicationComponent.builder()
            .contextModule(ContextModule(application))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchAuthFragment()
    }

    private fun launchAuthFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, LoginFragment.newInstance())
            .commit()
    }
}
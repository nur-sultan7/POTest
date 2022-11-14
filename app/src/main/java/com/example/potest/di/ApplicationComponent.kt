package com.example.potest.di

import com.example.potest.presentation.MainActivity
import dagger.Component

@Component(modules = [DomainModule::class, ContextModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
}
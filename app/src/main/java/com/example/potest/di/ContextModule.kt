package com.example.potest.di

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val context: Application) {
    @Provides
    fun provideContext() = context
}
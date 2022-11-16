package com.example.potest.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DomainModule::class, DataModule::class])
interface ApplicationComponent {

    fun profileComponentFactory(): ProfileComponent.Factory
    fun loginComponentFactory(): LoginComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}
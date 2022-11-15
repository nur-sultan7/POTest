package com.example.potest.di

import android.app.Application
import com.example.potest.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component


@Component(modules = [DomainModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}
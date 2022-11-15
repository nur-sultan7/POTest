package com.example.potest.di

import android.app.Application
import com.example.potest.presentation.LoginFragment
import com.example.potest.presentation.ProfileFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DomainModule::class, DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(fragment: ProfileFragment)
    fun inject(fragment: LoginFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}
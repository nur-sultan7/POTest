package com.example.potest.di

import com.example.potest.presentation.LoginFragment
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface LoginComponent {
    fun inject(fragment: LoginFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }
}
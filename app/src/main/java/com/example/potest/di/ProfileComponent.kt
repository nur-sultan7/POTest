package com.example.potest.di

import com.example.potest.presentation.ProfileFragment
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
interface ProfileComponent {
    fun inject(fragment: ProfileFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ProfileComponent
    }
}
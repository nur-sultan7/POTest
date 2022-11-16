package com.example.potest.di

import androidx.lifecycle.ViewModel
import com.example.potest.presentation.LoginViewModel
import com.example.potest.presentation.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    @Binds
    fun bindsLoginViewModel(impl: LoginViewModel): ViewModel

    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    @Binds
    fun bindsProfileViewModel(impl: ProfileViewModel): ViewModel
}
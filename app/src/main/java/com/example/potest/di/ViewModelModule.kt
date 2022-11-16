package com.example.potest.di

import androidx.lifecycle.ViewModel
import com.example.potest.presentation.LoginViewModel
import com.example.potest.presentation.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    @Binds
    abstract fun bindsLoginViewModel(impl: LoginViewModel):ViewModel

    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    @Binds
    abstract fun bindsProfileViewModel(impl: ProfileViewModel):ViewModel
}
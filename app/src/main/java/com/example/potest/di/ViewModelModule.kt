package com.example.potest.di

import androidx.lifecycle.ViewModel
import com.example.potest.presentation.LoginViewModel
import com.example.potest.presentation.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ViewModelModule {
    @IntoMap
    @StringKey("LoginViewModel")
    @Binds
    abstract fun bindsLoginViewModel(impl: LoginViewModel):ViewModel

    @IntoMap
    @StringKey("ProfileViewModel")
    @Binds
    abstract fun bindsProfileViewModel(impl: ProfileViewModel):ViewModel
}
package com.example.potest.di

import android.app.Application
import com.example.potest.data.database.AppDatabase
import com.example.potest.data.database.DatabaseDao
import com.example.potest.data.network.ApiFactory
import com.example.potest.data.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Singleton
    @Provides
    fun provideAppDatabase(application: Application): DatabaseDao {
        return AppDatabase.getInstance(application).databaseDao()
    }

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return ApiFactory.apiService
    }
}
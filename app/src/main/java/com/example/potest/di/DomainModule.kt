package com.example.potest.di

import com.example.potest.data.RepositoryImp
import com.example.potest.domain.Repository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindRepository(imp: RepositoryImp): Repository
}
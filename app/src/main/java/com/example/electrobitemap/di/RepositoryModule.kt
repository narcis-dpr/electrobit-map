package com.example.electrobitemap.di

import com.example.electrobitemap.data.repository.GetElektrobitLocationRepository
import com.example.electrobitemap.data.repository.GetElektrobitLocationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsElektrobitLocationRepository(
        getElektrobitLocationRepositoryImpl:
        GetElektrobitLocationRepositoryImpl
    ):
            GetElektrobitLocationRepository
}
package com.clean.data_layer.di

import com.clean.data_layer.repository.AuthRepositoryImpl
import com.clean.domain_layer.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthRepository(
        movieRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}
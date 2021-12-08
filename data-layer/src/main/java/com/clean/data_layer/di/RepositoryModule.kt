package com.clean.data_layer.di

import com.clean.data_layer.repository.AuthRepositoryImpl
import com.clean.data_layer.repository.UsersRepositoryImpl
import com.clean.domain_layer.repository.AuthRepository
import com.clean.domain_layer.repository.UsersRepository
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

    @Binds
    abstract fun bindUsersRepository(
        movieRepositoryImpl: UsersRepositoryImpl
    ): UsersRepository
}
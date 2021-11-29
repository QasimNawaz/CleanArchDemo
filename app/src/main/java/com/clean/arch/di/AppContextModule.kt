package com.clean.arch.di

import android.content.Context
import com.clean.arch.app.AppController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppContextModule {
    @Provides
    fun getApplicationContext(): Context = AppController.getAppContext().applicationContext
}
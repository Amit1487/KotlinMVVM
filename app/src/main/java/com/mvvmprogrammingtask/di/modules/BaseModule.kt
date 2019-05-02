package com.mvvmprogrammingtask.di.modules

import android.content.Context
import com.google.gson.Gson
import com.mvvmprogrammingtask.AppController

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class BaseModule(private val app: AppController) {


    @Provides
    @Singleton
    fun provideApp(): AppController = app

    @Provides
    @Singleton
    fun provideAppContext(): Context = app

    @Provides
    @Singleton
    fun provideGSON(): Gson = Gson()



}
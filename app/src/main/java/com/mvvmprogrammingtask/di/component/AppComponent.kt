package com.mvvmprogrammingtask.di.component

import com.mvvmprogrammingtask.di.modules.BuilderModule
import com.mvvmprogrammingtask.di.modules.NetworkModule
import com.mvvmprogrammingtask.di.modules.RepoModule
import com.mvvmprogrammingtask.di.modules.viewmodel.ViewModelModule
import com.mvvmprogrammingtask.di.modules.BaseModule
import com.mvvmprogrammingtask.AppController
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, BaseModule::class, NetworkModule::class, BuilderModule::class, RepoModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(app: AppController)
}
package com.mvvmprogrammingtask

import android.app.Activity
import android.app.Application
import com.mvvmprogrammingtask.di.component.DaggerAppComponent
import com.mvvmprogrammingtask.di.modules.BaseModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class AppController : Application() , HasActivityInjector {


    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
    private val appComponent by lazy {
        DaggerAppComponent.builder()
            .baseModule(BaseModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }


}

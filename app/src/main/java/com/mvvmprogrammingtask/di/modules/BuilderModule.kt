package com.mvvmprogrammingtask.di.modules


import com.mvvmprogrammingtask.feature.classification.ClassificationActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BuilderModule {


    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): ClassificationActivity

}
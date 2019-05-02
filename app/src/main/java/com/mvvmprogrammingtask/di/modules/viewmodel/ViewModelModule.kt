package com.mvvmprogrammingtask.di.modules.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.mvvmprogrammingtask.feature.classification.ClassificationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ClassificationViewModel::class)
    abstract fun bindsClassificationViewModel(viewModel: ClassificationViewModel): ViewModel

}
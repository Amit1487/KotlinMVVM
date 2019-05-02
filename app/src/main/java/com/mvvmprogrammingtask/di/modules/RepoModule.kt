package com.mvvmprogrammingtask.di.modules


import com.mvvmprogrammingtask.repository.ClassificationRepo
import com.mvvmprogrammingtask.repository.impl.ClassificationRepoImpl
import dagger.Binds
import dagger.Module


@Module
abstract class RepoModule {

   @Binds
   internal abstract fun bindClassficationRepo(repository: ClassificationRepoImpl): ClassificationRepo


}
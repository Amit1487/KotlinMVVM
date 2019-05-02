package com.mvvmprogrammingtask.repository.impl

import com.mvvmprogrammingtask.api.ClassificationAPI
import com.mvvmprogrammingtask.api.response.ClassificationResponse
import com.mvvmprogrammingtask.repository.ClassificationRepo
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClassificationRepoImpl @Inject constructor(private val classificationAPI: ClassificationAPI): ClassificationRepo {
    override fun getClassifications(page: Int): Observable<ClassificationResponse> {
       return  classificationAPI.getClassifications(page)
    }
}
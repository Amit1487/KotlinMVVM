package com.mvvmprogrammingtask.repository

import com.mvvmprogrammingtask.api.response.ClassificationResponse
import io.reactivex.Observable


interface ClassificationRepo {
    fun  getClassifications(page : Int) : Observable<ClassificationResponse>
}
package com.mvvmprogrammingtask.api

import com.mvvmprogrammingtask.api.response.ClassificationResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ClassificationAPI {
    @GET(ApiConstant.CLASSIFICATION_ENDPOINT)
    fun getClassifications(@Query("page") page : Int) : Observable<ClassificationResponse>
}
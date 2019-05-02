package com.mvvmprogrammingtask.base


import com.mvvmprogrammingtask.exception.Failure
import com.google.gson.Gson
import io.reactivex.Observer
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

abstract class BaseSubscriber<T> : Observer<T> {

    override fun onError(e: Throwable) {



        e.printStackTrace()
        when (e) {
            is IOException -> onFailure(Failure.NetworkConnection("You are not connected to Internet!"))
            is Failure -> onFailure(e)
            else -> onFailure(Failure.ServerError("Something went wrong Please try again later"))
        }
    }


    override fun onComplete() {}


    abstract fun onFailure(failure: Failure)


}

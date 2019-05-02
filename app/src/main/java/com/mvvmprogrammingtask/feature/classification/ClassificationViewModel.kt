package com.mvvmprogrammingtask.feature.classification

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.mvvmprogrammingtask.model.ViewStatus
import com.mvvmprogrammingtask.base.BaseSubscriber
import com.mvvmprogrammingtask.base.BaseViewModel
import com.mvvmprogrammingtask.displaymodel.ClassificationsDisplay
import com.mvvmprogrammingtask.exception.Failure
import com.mvvmprogrammingtask.usecase.ClassificationUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ClassificationViewModel @Inject constructor(private val classificationUseCase: ClassificationUseCase): BaseViewModel(){


    private val classificationData = MutableLiveData<ClassificationsDisplay>()

    fun observeClassificationData() : LiveData<ClassificationsDisplay> = classificationData

     fun loadClassificationData(page : Int){
        classificationUseCase.run(ClassificationUseCase.Param(page))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : BaseSubscriber<ClassificationsDisplay>() {
                override fun onFailure(failure: Failure) {
                    handleError(failure)
                }
                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onNext(t: ClassificationsDisplay) {
                    viewStatus.postValue(ViewStatus.SUCCESS)
                    classificationData.postValue(t)
                }
            })
    }

    fun refresh(){
        loadClassificationData(1)
    }
}
package com.mvvmprogrammingtask.usecase

import io.reactivex.Observable

abstract class UseCase<Type, Params> {
    abstract  fun run(params: Params): Observable<Type>
}

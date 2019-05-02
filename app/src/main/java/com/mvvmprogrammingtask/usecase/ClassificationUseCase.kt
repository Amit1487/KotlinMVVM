package com.mvvmprogrammingtask.usecase

import com.mvvmprogrammingtask.displaymodel.ClassificationItemDisplay
import com.mvvmprogrammingtask.displaymodel.ClassificationsDisplay
import com.mvvmprogrammingtask.repository.ClassificationRepo
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ClassificationUseCase @Inject constructor(private val repository: ClassificationRepo) : UseCase<ClassificationsDisplay, ClassificationUseCase.Param>() {
    override fun run(params: Param): Observable<ClassificationsDisplay> {
        return repository.getClassifications(params.page).map {
            it.results?.let {results ->
                ClassificationsDisplay(results.mapTo(ArrayList()) {result ->
                ClassificationItemDisplay(
                    name = result.name,
                    classification = result.classification,
                    designation = result.designation
                )
            })
            }
        }
    }

    data class Param( var page: Int)
}
package mgareta.themoviedb.domain

import io.reactivex.Observable
import mgareta.themoviedb.data.rest.ApiSource
import mgareta.themoviedb.data.rest.model.ResultMovie

/**
 * Created by marc on 16/03/18.
 */

class MainUseCaseImpl(private val apiSource: ApiSource) : MainUseCase {

    override fun getPopularMovie(page: Int): Observable<List<ResultMovie>> {
        return apiSource.getPopularMovie(page).map({
            resultList -> resultList.results!!
        })
    }

}
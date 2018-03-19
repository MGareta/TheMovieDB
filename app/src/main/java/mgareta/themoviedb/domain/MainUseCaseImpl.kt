package mgareta.themoviedb.domain

import io.reactivex.Observable
import mgareta.themoviedb.data.rest.ApiSource
import mgareta.themoviedb.data.rest.model.ResponseResultList
import mgareta.themoviedb.data.rest.model.ResultMovie

/**
 * Created by marc on 16/03/18.
 */

class MainUseCaseImpl(private val apiSource: ApiSource) : MainUseCase {

    override fun getPopularMovie(page: Int): Observable<ResponseResultList<ResultMovie>> {
        return apiSource.getPopularMovie(page).map({
            resultList -> resultList
        })
    }

    override fun getMovieSearch(page: Int, query: String): Observable<ResponseResultList<ResultMovie>> {
        return apiSource.getMovieSearch(page, query).map({
            resultList -> resultList
        })
    }
}
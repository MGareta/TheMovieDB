package mgareta.themoviedb.data.rest

import io.reactivex.Observable
import mgareta.themoviedb.data.rest.model.ResponseResultList
import mgareta.themoviedb.data.rest.model.ResultMovie

/**
 * Created by marc on 16/03/18.
 */

interface ApiSource {

    fun getPopularMovie(page: Int): Observable<ResponseResultList<ResultMovie>>

    fun getMovieSearch(page: Int, query: String): Observable<ResponseResultList<ResultMovie>>
}
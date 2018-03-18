package mgareta.themoviedb.domain

import io.reactivex.Observable
import mgareta.themoviedb.data.rest.model.ResponseResultList
import mgareta.themoviedb.data.rest.model.ResultMovie

/**
 * Created by marc on 16/03/18.
 */

interface MainUseCase {

    fun getPopularMovie(page: Int): Observable<ResponseResultList<ResultMovie>>

}
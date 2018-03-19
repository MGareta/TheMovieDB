package mgareta.themoviedb.data.rest

import io.reactivex.Observable
import mgareta.themoviedb.BuildConfig
import mgareta.themoviedb.data.rest.model.ResponseResultList
import mgareta.themoviedb.data.rest.model.ResultMovie
import retrofit2.Retrofit
import java.util.*

/**
 * Created by marc on 16/03/18.
 */

class ApiSourceImpl(retrofit: Retrofit) : ApiSource {

    private var retrofitInterface: RetrofitInterface = retrofit.create(RetrofitInterface::class.java)

    override fun getPopularMovie(page: Int): Observable<ResponseResultList<ResultMovie>> {
        return retrofitInterface.getPopular(BuildConfig.API_KEY, Locale.getDefault().language, page);
    }

    override fun getMovieSearch(page: Int, query: String): Observable<ResponseResultList<ResultMovie>> {
        return retrofitInterface.getMovieSearch(BuildConfig.API_KEY, Locale.getDefault().language, query, page)
    }

}
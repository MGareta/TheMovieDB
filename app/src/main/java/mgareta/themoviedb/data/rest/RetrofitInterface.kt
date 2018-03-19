package mgareta.themoviedb.data.rest

import io.reactivex.Observable
import mgareta.themoviedb.data.rest.model.ResponseResultList
import mgareta.themoviedb.data.rest.model.ResultMovie
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by marc on 16/03/18.
 */

interface RetrofitInterface {

    @GET("movie/popular")
    fun getPopular(@Query("api_key") apiKey: String,
                   @Query("language") language: String,
                   @Query("page") page: Int): Observable<ResponseResultList<ResultMovie>>

    @GET("search/movie")
    fun getMovieSearch(@Query("api_key") apiKey: String,
                       @Query("language") language: String,
                       @Query("query") query: String,
                       @Query("page") page: Int): Observable<ResponseResultList<ResultMovie>>
}
package mgareta.themoviedb.ui.main

import android.util.Log
import mgareta.themoviedb.data.rest.model.ResponseResultList
import mgareta.themoviedb.data.rest.model.ResultMovie
import mgareta.themoviedb.domain.MainUseCase
import mgareta.themoviedb.ui.base.BasePresenter
import mgareta.themoviedb.util.RxTransformer
import javax.inject.Inject

/**
 * Created by marc on 16/03/18.
 */

class MainPresenter @Inject constructor(private val mainUseCase: MainUseCase) : BasePresenter<MainContract.View>(), MainContract.Presenter {

    private var pageIndex: Int = 1
    private var totalPages: Int = 1
    private lateinit var query: String

    private var searchControl = false

    override fun onViewReady() {
        if (pageIndex != 1)
            pageIndex = 1

        this.searchControl = false

        getPopularMovie(pageIndex)
    }

    override fun searchMovie(query: String) {
        if (pageIndex != 1)
            pageIndex = 1

        this.query = query
        this.searchControl = true

        getSearchMovie(pageIndex, query)
    }

    override fun decideLoadMore() {
        if (pageIndex <= totalPages) {
            if (!searchControl)
                getPopularMovie(pageIndex)
            else
                getSearchMovie(pageIndex, query)
        }
    }

    private fun getPopularMovie(page: Int) {
        mainUseCase.getPopularMovie(page).compose(RxTransformer().applyIOSchedulers<ResponseResultList<ResultMovie>>())
                .subscribe({ movies ->
                    if (page == 1) {
                        view.loadMovieList(movies.results!!)
                        totalPages = movies.totalPages!!
                    } else
                        view.loadMoreMovieList(movies.results!!)

                    pageIndex = movies.page?.inc()!!
                }, { throwable ->
                    Log.d("ERROR", "accept: " + throwable.message)
                })
    }

    private fun getSearchMovie(page: Int, query: String) {
        mainUseCase.getMovieSearch(page, query).compose(RxTransformer().applyIOSchedulers<ResponseResultList<ResultMovie>>())
                .subscribe({ movies ->
                    if (page == 1) {
                        view.loadMovieList(movies.results!!)
                        totalPages = movies.totalPages!!
                    } else
                        view.loadMoreMovieList(movies.results!!)

                    pageIndex = movies.page?.inc()!!
                }, { throwable ->
                    Log.d("ERROR", "accept: " + throwable.message)
                })
    }
}
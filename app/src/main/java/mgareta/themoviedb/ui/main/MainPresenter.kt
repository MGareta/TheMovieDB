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

class MainPresenter @Inject constructor(private val mainUseCase: MainUseCase): BasePresenter<MainContract.View>(), MainContract.Presenter {

    private var pageIndex = 1
    private var totalPages: Int = 1

    override fun onViewReady() {
        getPopularMovie(pageIndex)
    }

    override fun decideLoadMore() {
        if (pageIndex <= totalPages)
            getPopularMovie(pageIndex)
    }

    private fun getPopularMovie(page: Int) {
        mainUseCase.getPopularMovie(page).compose(RxTransformer().applyIOSchedulers<ResponseResultList<ResultMovie>>())
                .subscribe({ movies ->
                    if (page == 1) {
                        view.loadMovieList(movies.results!!)
                        totalPages = movies.totalPages!!
                    }
                    else
                        view.loadMoreMovieList(movies.results!!)

                    pageIndex = movies.page?.inc()!!
                }, {
                    throwable -> Log.d("ERROR", "accept: " + throwable.message)
                })
    }
}
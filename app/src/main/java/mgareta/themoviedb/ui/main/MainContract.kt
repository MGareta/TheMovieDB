package mgareta.themoviedb.ui.main

import mgareta.themoviedb.data.rest.model.ResultMovie
import mgareta.themoviedb.ui.base.BaseView

/**
 * Created by marc on 16/03/18.
 */

class MainContract {

    interface View : BaseView {

        fun isConnect(): Boolean

        fun loadMovieList(movieList: ArrayList<ResultMovie>)

        fun loadMoreMovieList(movieList: ArrayList<ResultMovie>)

    }

    interface Presenter {

        fun onViewReady()

        fun decideLoadMore()

    }
}
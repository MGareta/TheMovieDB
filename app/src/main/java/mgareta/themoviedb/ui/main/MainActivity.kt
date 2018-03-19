package mgareta.themoviedb.ui.main

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import mgareta.themoviedb.R
import mgareta.themoviedb.data.rest.model.ResultMovie
import mgareta.themoviedb.di.main.DaggerMainComponent
import mgareta.themoviedb.di.main.MainModule
import mgareta.themoviedb.ui.base.BaseActivity
import javax.inject.Inject

/**
 * Created by marc on 17/03/18.
 */

class MainActivity : BaseActivity(), MainContract.View {

    private lateinit var movieAdapter: MainAdapter<ResultMovie>
    private lateinit var layoutManager: LinearLayoutManager

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onViewReady(savedInstanceState: Bundle?) {
        resolveDaggerDependency()

        setUpUiComponents()

        mainPresenter.onViewReady()
    }

    override fun resolveDaggerDependency() {
        DaggerMainComponent.builder()
                .appComponent(getApplicationComponent())
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun isConnect(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUpUiComponents() {
        movieAdapter = MainAdapter()
        layoutManager = LinearLayoutManager(this)

        recycler_view_movie.layoutManager = layoutManager
        recycler_view_movie.isNestedScrollingEnabled = false
        recycler_view_movie.adapter = movieAdapter
        recycler_view_movie.addItemDecoration(DividerItemDecoration(recycler_view_movie.context, layoutManager.orientation))

        recycler_view_movie.addOnScrollListener(recyclerViewOnScrollListener)

        edit_text_search_movie.addTextChangedListener(editTextChangeListener)
    }

    override fun loadMovieList(movieList: ArrayList<ResultMovie>) {
        movieAdapter.setMovieList(movieList)
    }

    override fun loadMoreMovieList(movieList: ArrayList<ResultMovie>) {
        movieAdapter.addMovieList(movieList)
    }

    private val recyclerViewOnScrollListener = object: RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView:RecyclerView, dx:Int, dy:Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

            if (((visibleItemCount.plus(firstVisibleItemPosition)) >= (totalItemCount.minus(REMAIN_ITEM_COUNT_TO_LOAD_MORE))
                    && firstVisibleItemPosition >= 0)) {
                mainPresenter.decideLoadMore()
            }
        }
    }

    private val editTextChangeListener = object: TextWatcher {

        override fun afterTextChanged(s: Editable?) {
            // do nothing
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // do nothing
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s?.length != 0)
                mainPresenter.searchMovie(s.toString())
            else
                mainPresenter.onViewReady()
        }
    }
}
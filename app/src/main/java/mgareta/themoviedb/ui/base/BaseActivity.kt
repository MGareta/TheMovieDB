package mgareta.themoviedb.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import mgareta.themoviedb.TheMovieDBApp
import mgareta.themoviedb.di.app.AppComponent

/**
 * Created by marc on 16/03/18.
 */

abstract class BaseActivity : AppCompatActivity() {

    protected val REMAIN_ITEM_COUNT_TO_LOAD_MORE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())

        onViewReady(savedInstanceState)
    }

    protected fun getApplicationComponent(): AppComponent {
        return (application as TheMovieDBApp).appComponent
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun onViewReady(savedInstanceState: Bundle?)

    protected abstract fun resolveDaggerDependency()

    protected abstract fun setUpUiComponents()
}
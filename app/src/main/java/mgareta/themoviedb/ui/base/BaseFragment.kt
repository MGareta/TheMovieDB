package mgareta.themoviedb.ui.base

import android.app.Activity
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mgareta.themoviedb.TheMovieDBApp
import mgareta.themoviedb.di.app.AppComponent

/**
 * Created by marc on 16/03/18.
 */

//Not Used
abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onViewReady()
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    @CallSuper
    private fun onViewReady() {
        resolveDaggerDependency()
    }

    protected fun getApplicationComponent(): AppComponent {
        return ((context as Activity).application as TheMovieDBApp).appComponent
    }

    private fun resolveDaggerDependency() {

    }
}
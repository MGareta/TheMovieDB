package mgareta.themoviedb.ui.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

/**
 * Created by marc on 16/03/18.
 */

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())

        onViewReady(savedInstanceState)
    }

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    @CallSuper
    protected fun onViewReady(savedInstanceState: Bundle?) {
        resolveDaggerDependency()

        setUpUiComponents()
    }

    protected fun resolveDaggerDependency() {

    }

    protected abstract fun setUpUiComponents()

}
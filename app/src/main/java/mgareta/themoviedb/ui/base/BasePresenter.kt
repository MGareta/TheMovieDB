package mgareta.themoviedb.ui.base

import javax.inject.Inject

/**
 * Created by marc on 16/03/18.
 */

open class BasePresenter<V : BaseView> {

    @Inject
    lateinit var view: V
}
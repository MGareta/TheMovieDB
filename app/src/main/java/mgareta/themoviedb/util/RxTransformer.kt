package mgareta.themoviedb.util

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by marc on 17/03/18.
 */

class RxTransformer {

    fun <T> applyIOSchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
        }
    }
}
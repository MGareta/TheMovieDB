package mgareta.themoviedb.di.app

import android.content.Context
import dagger.Component
import mgareta.themoviedb.TheMovieDBApp
import mgareta.themoviedb.data.rest.ApiSource
import javax.inject.Singleton

/**
 * Created by marc on 16/03/18.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {

    fun context(): Context

    fun apiSource(): ApiSource

    fun inject(app: TheMovieDBApp)

}
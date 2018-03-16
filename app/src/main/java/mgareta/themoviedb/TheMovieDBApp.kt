package mgareta.themoviedb

import android.app.Application
import mgareta.themoviedb.di.app.AppComponent
import mgareta.themoviedb.di.app.AppModule
import mgareta.themoviedb.di.app.DaggerAppComponent
import mgareta.themoviedb.di.app.NetworkModule

/**
 * Created by marc on 16/03/18.
 */

class TheMovieDBApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()

        appComponent.inject(this)
    }
}
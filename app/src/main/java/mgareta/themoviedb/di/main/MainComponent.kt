package mgareta.themoviedb.di.main

import dagger.Component
import mgareta.themoviedb.di.PerActivity
import mgareta.themoviedb.di.app.AppComponent
import mgareta.themoviedb.ui.main.MainActivity

/**
 * Created by marc on 17/03/18.
 */

@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {

    fun inject(mainActivity: MainActivity)
}
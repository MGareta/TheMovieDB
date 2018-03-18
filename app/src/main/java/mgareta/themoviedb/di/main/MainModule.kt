package mgareta.themoviedb.di.main

import dagger.Module
import dagger.Provides
import mgareta.themoviedb.data.rest.ApiSource
import mgareta.themoviedb.di.PerActivity
import mgareta.themoviedb.domain.MainUseCase
import mgareta.themoviedb.domain.MainUseCaseImpl
import mgareta.themoviedb.ui.main.MainContract

/**
 * Created by marc on 17/03/18.
 */

@Module
class MainModule(private val view: MainContract.View) {

    @PerActivity
    @Provides
    fun provideView(): MainContract.View {
        return view
    }

    @PerActivity
    @Provides
    fun provideMainUseCase(apiSource: ApiSource): MainUseCase {
        return MainUseCaseImpl(apiSource)
    }
}
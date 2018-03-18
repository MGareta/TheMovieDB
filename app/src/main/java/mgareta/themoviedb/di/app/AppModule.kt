package mgareta.themoviedb.di.app

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.google.gson.GsonBuilder
import com.google.gson.Gson



/**
 * Created by marc on 16/03/18.
 */

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return app
    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().setDateFormat("yyyy-MM-dd").create()
    }
}
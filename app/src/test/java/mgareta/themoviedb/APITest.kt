package mgareta.themoviedb

import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by marc on 20/03/18.
 */

class APITest {
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
    }

    @Test
    fun checkConnection() {
        val url = BuildConfig.BASE_URL

        val retrofit = Retrofit.Builder()
                .baseUrl(mockWebServer.url(url))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        Assert.assertNotNull(retrofit)
    }
}
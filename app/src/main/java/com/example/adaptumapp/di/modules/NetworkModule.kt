package com.example.adaptumapp.di.modules

import com.example.adaptumapp.data.network.AuthApi
import com.example.adaptumapp.domain.handler.TokenDataHandler
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitDefault(tokenDataHandler: TokenDataHandler): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(provideHttpClient(tokenDataHandler))
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    @Provides
    @Singleton
    @Named("AuthInterceptor")
    fun provideRetrofit(tokenDataHandler: TokenDataHandler): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(provideHttpClient(tokenDataHandler))
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    @Provides
    @Singleton
    @Named("NoAuthInterceptor")
    fun provideRetrofitNoAuth(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(provideHttpClientNoAuth())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    private fun provideHttpClient(tokenDataHandler: TokenDataHandler) = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .addInterceptor(AuthInterceptor(tokenDataHandler))
        .build()

    private fun provideHttpClientNoAuth() = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    @Named("AuthInterceptor")
    fun provideAuthApi(@Named("AuthInterceptor") retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Provides
    @Named("NoAuthInterceptor")
    fun provideNoAuthApi(@Named("NoAuthInterceptor") retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    companion object {
        private const val BASE_URL = "http://192.168.1.43:8000/"
    }

}

private class AuthInterceptor(
    private val tokenDataHandler: TokenDataHandler
) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("Authorization", "Token ${tokenDataHandler.getToken().token}")
            .method(originalRequest.method, originalRequest.body)

        val modifiedRequest = requestBuilder.build()
        return chain.proceed(modifiedRequest)
    }
}
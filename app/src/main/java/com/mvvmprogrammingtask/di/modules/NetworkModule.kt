package com.mvvmprogrammingtask.di.modules


import com.mvvmprogrammingtask.BuildConfig
import com.mvvmprogrammingtask.api.ApiConstant
import com.mvvmprogrammingtask.api.ClassificationAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit(converterFactory: Converter.Factory, adapterFactory: CallAdapter.Factory, client: OkHttpClient, @Named("baseUrl") baseUrl: String): Retrofit = Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .client(client)
            .baseUrl(baseUrl)
            .build()


    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideGSONFactory(): Converter.Factory = GsonConverterFactory.create()


    @Singleton
    @Provides
    fun provideRxAdapter(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()


    @Singleton
    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(): String = ApiConstant.BASE_URL


    @Singleton
    @Provides
    fun providesAppAPI(retrofit: Retrofit) = retrofit.create(ClassificationAPI::class.java)


}
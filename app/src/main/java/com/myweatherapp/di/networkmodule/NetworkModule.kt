package com.myweatherapp.di.networkmodule

import android.content.Context
import com.myweatherapp.resource.Constants
import com.myweatherapp.resource.NetworkCheckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl() = Constants.getBaseUrl()

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext appContext: Context) =
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).addInterceptor(
            NetworkCheckInterceptor(appContext)
        ).build()


    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, BASE_URL: String) = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl(BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper = apiHelperImpl
}
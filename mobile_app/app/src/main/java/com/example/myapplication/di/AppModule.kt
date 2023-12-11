package com.example.myapplication.di

import com.example.myapplication.network.AppAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://9d49-41-210-141-31.ngrok-free.app"

    @Singleton
    @Provides
    fun provideAPI(): AppAPI {
        val clientProvider: OkHttpClient = provideOkHttpClient()
        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clientProvider)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(AppAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }




}

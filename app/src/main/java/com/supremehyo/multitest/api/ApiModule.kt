package com.supremehyo.multitest.api

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
object  ApiModule {

    val BASE_URL = "https://api.github.com"

    @Singleton
    @Provides
    fun getRetroServiceInstance(retrofit: Retrofit) : RetroServiceInstance{
        return retrofit.create(RetroServiceInstance::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}


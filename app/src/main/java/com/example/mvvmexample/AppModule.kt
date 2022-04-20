package com.example.mvvmexample

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 object AppModule {


    val BASE_URL="https://api.collectapi.com/corona/"

    @Provides
    @Singleton
    fun provideAnalyticsService(

    ): AnalyticsService {
        return Retrofit.Builder()
            .baseUrl("https://api.collectapi.com/corona/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnalyticsService::class.java)
    }

}
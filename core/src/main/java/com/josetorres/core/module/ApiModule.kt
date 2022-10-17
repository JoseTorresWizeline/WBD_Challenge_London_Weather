package com.josetorres.core.module

import com.josetorres.core.api.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideApiInterface(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

}
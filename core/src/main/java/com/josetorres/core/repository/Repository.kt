package com.josetorres.core.repository

import com.josetorres.core.api.ApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val mRemoteDataSource: RemoteDataSource) : DataSource {
    override suspend fun getCityWeather(cityName: String): ApiResponse? {
        return mRemoteDataSource.getCityWeather(cityName)
    }
}
package com.josetorres.core.repository

import com.josetorres.core.api.ApiInterface
import com.josetorres.core.api.ApiResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val mApi: ApiInterface) : DataSource {
    override suspend fun getCityWeather(cityName: String): ApiResponse? {
        val response = mApi.getCityWeather()
        return response.body()
    }
}
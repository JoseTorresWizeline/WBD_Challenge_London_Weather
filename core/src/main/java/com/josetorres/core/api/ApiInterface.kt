package com.josetorres.core.api

import com.josetorres.core.api.ApiConstants.APP_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather?q=London,uk&units=metric")
    suspend fun getCityWeather(@Query("APPID") appId: String = APP_ID): Response<ApiResponse>
}
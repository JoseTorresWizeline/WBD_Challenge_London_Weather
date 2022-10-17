package com.josetorres.core.repository

import com.josetorres.core.api.ApiResponse

interface DataSource {

    /**
     * GETS
     */

    /**
     * Get the city weather
     */
    suspend fun getCityWeather(cityName: String): ApiResponse?
}
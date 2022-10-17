package com.josetorres.core.api

import com.google.gson.annotations.SerializedName
import com.josetorres.core.data.CityWeather

data class ApiResponse(
    @SerializedName("cod")
    val code: Int,
    @SerializedName("name")
    val cityName: String,
    @SerializedName("main")
    val cityWeather: CityWeather
)

package com.josetorres.core.api

import com.google.gson.annotations.SerializedName
import com.josetorres.core.data.CityTemperature
import com.josetorres.core.data.CityWeather

data class ApiResponse(
    @SerializedName("cod")
    val code: Int,
    @SerializedName("name")
    val cityName: String,
    @SerializedName("main")
    val cityTemperature: CityTemperature,
    @SerializedName("weather")
    val cityWeather: List<CityWeather>
)

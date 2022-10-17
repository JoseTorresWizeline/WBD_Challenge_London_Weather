package com.josetorres.core.data

import com.google.gson.annotations.SerializedName

data class CityWeather(
    @SerializedName("temp")
    val currentTemperature: Double,
    @SerializedName("temp_min")
    val currentMinimumTemperature: Double,
    @SerializedName("temp_max")
    val currentMaxTemperature: Double,
    @SerializedName("humidity")
    val currentHumidity: Int
)
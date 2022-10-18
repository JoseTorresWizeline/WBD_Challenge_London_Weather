package com.josetorres.core.data

import com.google.gson.annotations.SerializedName

data class CityWeather(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val mainDescription: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String
)

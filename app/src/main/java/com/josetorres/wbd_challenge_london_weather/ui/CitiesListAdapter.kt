package com.josetorres.wbd_challenge_london_weather.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.josetorres.core.api.ApiResponse
import com.josetorres.wbd_challenge_london_weather.R
import com.josetorres.wbd_challenge_london_weather.databinding.ItemCityBinding
import kotlin.coroutines.coroutineContext

class CitiesListAdapter(val clickListener: CityClickListener) :
    ListAdapter<ApiResponse, CitiesListAdapter.CityViewHolder>(DiffCallback) {

    class CityViewHolder(var binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: CityClickListener, cityData: ApiResponse) {
            binding.cityData = cityData
            binding.weather = cityData.cityWeather.first()
            binding.weatherIcon = getIconDrawable(cityData.cityWeather.first().icon)
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        fun getIconDrawable(icon: String): Int {
            return when (icon) {
                "01d" -> R.drawable._1d
                "01n" -> R.drawable._1n
                "02d" -> R.drawable._2d
                "02n" -> R.drawable._2n
                "03d" -> R.drawable._3d
                "03n" -> R.drawable._3n
                "04d" -> R.drawable._4d
                "04n" -> R.drawable._4n
                "09d" -> R.drawable._9d
                "09n" -> R.drawable._9n
                "10d" -> R.drawable._10d
                "10n" -> R.drawable._10n
                "11d" -> R.drawable._11d
                "11n" -> R.drawable._11n
                "13d" -> R.drawable._13d
                "13n" -> R.drawable._13n
                "50d" -> R.drawable._50d
                "50n" -> R.drawable._50n
                else -> R.drawable._1d
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ApiResponse>() {
        override fun areItemsTheSame(oldItem: ApiResponse, newItem: ApiResponse): Boolean {
            return oldItem.cityName == newItem.cityName
        }

        override fun areContentsTheSame(oldItem: ApiResponse, newItem: ApiResponse): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CityViewHolder(ItemCityBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = getItem(position)
        holder.bind(clickListener, city)
    }
}

class CityClickListener(val clickListener: (cityData: ApiResponse) -> Unit) {
    fun onClick(cityData: ApiResponse) = clickListener(cityData)
}
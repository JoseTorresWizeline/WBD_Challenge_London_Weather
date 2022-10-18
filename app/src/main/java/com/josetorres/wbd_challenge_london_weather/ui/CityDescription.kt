package com.josetorres.wbd_challenge_london_weather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.josetorres.wbd_challenge_london_weather.R
import com.josetorres.wbd_challenge_london_weather.databinding.FragmentCityDescriptionBinding
import com.josetorres.wbd_challenge_london_weather.viewModel.MainViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityDescription : Fragment() {

    private val mViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCityDescriptionBinding.inflate(inflater)
        mViewModel.city.value?.let { value ->
            val cityWeather = value.cityWeather.first()
            val cityTemperature = value.cityTemperature
            binding.lifecycleOwner = this
            binding.weatherIcon = getIconDrawable(cityWeather.icon)
            binding.nameCity = value.cityName
            binding.cityTemperature = cityTemperature
            binding.cityWeather = cityWeather
        }

        return binding.root
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
package com.josetorres.wbd_challenge_london_weather.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josetorres.core.api.ApiResponse
import com.josetorres.core.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mRepository: Repository) : ViewModel() {

    private val _citiesData = MutableLiveData<List<ApiResponse>>()
    val citiesData: LiveData<List<ApiResponse>> get() = _citiesData

    private val _city = MutableLiveData<ApiResponse>()
    val city: LiveData<ApiResponse> get() = _city

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                mRepository.getCityWeather("London")?.let {
                    launch(Dispatchers.Main) { _citiesData.value = listOf(it) }
                }
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }
    }

    fun onCityClicked(cityData: ApiResponse) {
        _city.value = cityData
    }

    companion object {
        private const val TAG = "MainViewModel"
    }

}
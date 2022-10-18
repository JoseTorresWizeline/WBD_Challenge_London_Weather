package com.josetorres.wbd_challenge_london_weather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.josetorres.wbd_challenge_london_weather.R
import com.josetorres.wbd_challenge_london_weather.databinding.FragmentCitiesListBinding
import com.josetorres.wbd_challenge_london_weather.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitiesList : Fragment() {

    private val mViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCitiesListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = mViewModel
        binding.citiesRecyclerView.adapter = CitiesListAdapter(CityClickListener { city ->
            mViewModel.onCityClicked(city)
            findNavController().navigate(R.id.action_citiesList_to_cityDescription)
        })

        return binding.root
    }
}
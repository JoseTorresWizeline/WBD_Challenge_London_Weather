package com.josetorres.wbd_challenge_london_weather

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.josetorres.core.api.ApiResponse
import com.josetorres.wbd_challenge_london_weather.ui.CitiesListAdapter

/**
 * Updates the data shown in the [RecyclerView]
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<ApiResponse>?) {
    val adapter = recyclerView.adapter as CitiesListAdapter
    adapter.submitList(data)
}
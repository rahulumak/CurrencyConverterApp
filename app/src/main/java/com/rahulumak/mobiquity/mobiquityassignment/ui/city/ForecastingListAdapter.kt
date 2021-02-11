package com.rahulumak.mobiquity.mobiquityassignment.ui.city

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rahulumak.mobiquity.mobiquityassignment.R
import com.rahulumak.mobiquity.mobiquityassignment.databinding.ItemDayForecastingBinding

class ForecastingListAdapter:
    RecyclerView.Adapter<ForecastingListAdapter.ForecastItemViewHolder>() {
    var itemList = listOf<DayForecast>()

    inner class ForecastItemViewHolder(private val binding:ItemDayForecastingBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DayForecast) {
            binding.apply {
                dayForecast = item
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastItemViewHolder {
        return DataBindingUtil.inflate<ItemDayForecastingBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_day_forecasting,
            parent,
            false
        ).let {
            ForecastItemViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ForecastItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}
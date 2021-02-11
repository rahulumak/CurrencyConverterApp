package com.rahulumak.mobiquity.mobiquityassignment.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rahulumak.mobiquity.mobiquityassignment.R
//import com.rahulumak.mobiquity.mobiquityassignment.databinding.ItemCityListBinding
import com.rahulumak.mobiquity.mobiquityassignment.model.City
import kotlinx.android.synthetic.main.item_city_list.view.*

class CityAdapter(private val onCityDeleteListener: OnCityClickListener) :
    RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    var cities = listOf<City>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_city_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
//        holder.bind(cities[position])
        holder.itemView.txtCityName.text = cities[position].name
        holder.itemView.imgDelete.setOnClickListener {
            onCityDeleteListener.onCityDeleteClick(cities[position])
        }
        holder.itemView.setOnClickListener {
            onCityDeleteListener.onCityClick(cities[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    class CityViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)
    interface OnCityClickListener {
        fun onCityDeleteClick(city: City)
        fun onCityClick(city: City)
    }
//    class CityViewHolder(private val binding:ItemCityListBinding):RecyclerView.ViewHolder(binding.root){
//        init {
//            binding.cardCity.setOnClickListener {
//
//            }
//            binding.imgDelete.setOnClickListener {
//
//            }
//        }
//        fun bind(item: City){
//            binding.apply {
//                city=item
//                executePendingBindings()
//            }
//        }
//    }
}
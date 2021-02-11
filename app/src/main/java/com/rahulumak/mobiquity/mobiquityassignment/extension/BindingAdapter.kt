package com.rahulumak.mobiquity.mobiquityassignment.extension

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahulumak.mobiquity.mobiquityassignment.R
import com.rahulumak.mobiquity.mobiquityassignment.model.WeatherModel


@BindingAdapter("bind:loadUrl")
fun bindUrlImage(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .circleCrop()
        .into(view)
}
@BindingAdapter("bind:loadWeatherIcon")
fun loadWeatherIcon(view: ImageView, weatherModel: WeatherModel?) {
    weatherModel?.apply {
        Glide.with(view)
            .load(weatherModel.weather.first().getIconUrl())
            .circleCrop()
            .into(view)
    }
}

@BindingAdapter("bind:toSmallDate")
fun bindToSmallDate(view: TextView, date: Long) {
    try {
        view.text = Converters.toSmallDate(date)
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

//@BindingAdapter("bind:profileName")
//fun bindToSmallDate(view: TextView, name: Matches.Invitation.Name) {
//    view.text = "${name.first} ${name.last}"
//}
//
@BindingAdapter("bind:bindWeatherText")
fun bindWeatherText(view: TextView, weatherModel: WeatherModel?) {
    weatherModel?.apply {
        view.text =weatherModel.weather.first().main
    }

}
@BindingAdapter("bind:bindIntText")
fun bindIntText(view: TextView, value:Int?) {
    value?.apply {
        view.text =value.toString()
    }

}
@BindingAdapter("bind:bindDoubleText")
fun bindDoubleText(view: TextView, value:Double?) {
    value?.apply {
        view.text =value.toString()+view.context.resources.getString(R.string.degree_celsius)
    }

}

@BindingAdapter("bind:show")
fun show(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("bind:adapter")
fun setAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
    view.adapter = baseAdapter
}
@BindingAdapter("bind:humidityText")
fun humidityText(view: TextView, value:Int) {
    view.text ="${value}%"

}
@BindingAdapter("bind:windText")
fun txtWindText(view: TextView, value:Double) {
    view.text ="${value} km/h"

}
//@BindingAdapter("bind:items")
//fun setItems(view: RecyclerView, items: List<Matches.Invitation>?) {
//    val invitationsAdapter = view.adapter as InvitationsAdapter
//    invitationsAdapter.itemList = items ?: emptyList()
//    invitationsAdapter.notifyDataSetChanged()
//}
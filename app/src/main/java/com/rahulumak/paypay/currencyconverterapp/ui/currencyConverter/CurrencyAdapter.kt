package com.rahulumak.paypay.currencyconverterapp.ui.currencyConverter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahulumak.paypay.currencyconverterapp.R
//import com.rahulumak.paypay.currencyconverterapp.databinding.ItemCityListBinding
import com.rahulumak.paypay.currencyconverterapp.model.Currency
import kotlinx.android.synthetic.main.item_exchange_list.view.*

class CurrencyAdapter() :
    RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    var currencyList = listOf<Currency>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        return CurrencyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_exchange_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
//        holder.bind(cities[position])
        holder.itemView.txtCurrencyCode.text = currencyList[position].code
        holder.itemView.txtExchangesRate.text = String.format("%.4f",currencyList[position].rate)

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }

    class CurrencyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)


}
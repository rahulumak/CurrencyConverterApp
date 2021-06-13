package com.rahulumak.paypay.currencyconverterapp.ui.currencyConverter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.rahulumak.paypay.currencyconverterapp.R
import com.rahulumak.paypay.currencyconverterapp.model.Currency
import kotlinx.android.synthetic.main.custom_spinner.view.*

class CustomSpinnerAdapter(private val context: Context, private val currencies: List<Currency>): BaseAdapter() {

    override fun getCount(): Int {
        return currencies.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_spinner,p2,false)
        val txtCurrencyName=view.findViewById<TextView>(R.id.txtCurrencyName)
        val txtCurrencyCode=view.findViewById<TextView>(R.id.txtCurrencyCode)
        txtCurrencyName.text = currencies[p0].name
        txtCurrencyCode.text = "(${currencies[p0].code})"
        return view
    }
}
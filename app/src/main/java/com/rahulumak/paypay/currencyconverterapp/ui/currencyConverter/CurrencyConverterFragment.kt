package com.rahulumak.paypay.currencyconverterapp.ui.currencyConverter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rahulumak.paypay.currencyconverterapp.R
import kotlinx.android.synthetic.main.fragment_currency_converter.*
import org.koin.android.viewmodel.ext.android.viewModel

class CurrencyConverterFragment : Fragment(), View.OnClickListener {

    private val TAG=CurrencyConverterFragment::class.java.simpleName
    private val currencyViewModel: CurrencyConverterViewModel by viewModel()
    private lateinit var currencyAdapter: CurrencyAdapter
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_currency_converter, container, false)


        val recyclerViewExchangeRates: RecyclerView = root.findViewById(R.id.recyclerViewCurrency)
        val btnConvert: Button = root.findViewById(R.id.btnConvert)

        btnConvert.setOnClickListener(this)
        navController = findNavController()
        currencyAdapter = CurrencyAdapter()
        recyclerViewExchangeRates.adapter = currencyAdapter

        recyclerViewExchangeRates.layoutManager=GridLayoutManager(context,2)

        val context=requireParentFragment().requireContext()
        currencyViewModel.currencyList.observe(viewLifecycleOwner, Observer {
            val currencyList=currencyViewModel.currencyList.value!!
            val customSpinnerAdapter=CustomSpinnerAdapter(context,currencyList)
            spinnerCurrency.adapter=customSpinnerAdapter

        })

        currencyViewModel.conversionValue.observe(viewLifecycleOwner,Observer{
            txtConvertedValue.text= "${currencyViewModel.currencyList.value!![spinnerCurrency.selectedItemPosition].code!!} ${String.format("%.4f",it)}"
            currencyViewModel.getAvailableExchangeList()
        })
        currencyViewModel.exchangeList.observe(viewLifecycleOwner,Observer{
            currencyAdapter.currencyList=it
            currencyAdapter.notifyDataSetChanged()
        })
        return root
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnConvert -> {
                currencyConvert()
            }

        }
    }

    override fun onResume() {
        super.onResume()
        currencyViewModel.getCurrencies()
        currencyViewModel.getAvailableExchangeList()
    }
     private fun currencyConvert(){
        if (edtAmount.text.toString().isNotEmpty()) {
            currencyViewModel.getConversion(currencyViewModel.currencyList.value!![spinnerCurrency.selectedItemPosition].code!!,edtAmount.text.toString().toDouble())

        }else{
            Toast.makeText(context,getString(R.string.txt_enter_value),Toast.LENGTH_SHORT).show()
        }
    }


}
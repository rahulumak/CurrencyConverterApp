package com.rahulumak.mobiquity.mobiquityassignment.ui.city

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.rahulumak.mobiquity.mobiquityassignment.R
import com.rahulumak.mobiquity.mobiquityassignment.config.ProjectConfig
import com.rahulumak.mobiquity.mobiquityassignment.databinding.FragmentCityBinding

import com.rahulumak.mobiquity.mobiquityassignment.model.City
import com.rahulumak.mobiquity.mobiquityassignment.model.WeatherModel
import com.rahulumak.mobiquity.mobiquityassignment.ui.home.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class CityFragment : Fragment() {

    private val cityViewModel: CityViewModel by viewModel()
    private val args: CityFragmentArgs by navArgs()
    private lateinit var root: View
    private lateinit var mCity: City

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCityBinding.inflate(inflater, container, false)
        context ?: return binding.root
        mCity = args.city
        binding.apply {
            lifecycleOwner = this@CityFragment
            city = mCity
            viewModel = cityViewModel
        }
        root = binding.root

        cityViewModel.getWeatherData(
            mCity.latitude!!,
            mCity.longitude!!,
            ProjectConfig.API_KEY,
            ProjectConfig.CONVERSION_UNITS
        )

        return root
    }
}
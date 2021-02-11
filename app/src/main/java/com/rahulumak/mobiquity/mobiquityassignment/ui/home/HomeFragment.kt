package com.rahulumak.mobiquity.mobiquityassignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rahulumak.mobiquity.mobiquityassignment.R
import com.rahulumak.mobiquity.mobiquityassignment.model.City
import com.rahulumak.mobiquity.mobiquityassignment.ui.city.CityFragmentArgs
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), View.OnClickListener, CityAdapter.OnCityClickListener {

    //    private lateinit var homeViewModel: HomeViewModel
    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var cityAdapter: CityAdapter
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val fabAdd: FloatingActionButton = root.findViewById(R.id.fabAdd)
        val recyclerViewCity: RecyclerView = root.findViewById(R.id.recyclerViewCity)
        fabAdd.setOnClickListener(this)
        navController = findNavController()
        cityAdapter = CityAdapter(this)
        recyclerViewCity.adapter = cityAdapter
        recyclerViewCity.itemAnimator
        homeViewModel.cityList.observe(viewLifecycleOwner, Observer {
            cityAdapter.cities = homeViewModel.cityList.value!!
            cityAdapter.notifyDataSetChanged()
        })
        return root
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.fabAdd -> {
                navController.navigate(R.id.action_navigation_home_to_navigation_map)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.getBookmarkCities()
    }

    override fun onCityDeleteClick(city: City) {
        homeViewModel.deleteCity(city.id)
    }

    override fun onCityClick(city: City) {
        val direction=HomeFragmentDirections.actionNavigationHomeToNavigationCity(city)
        navController.navigate(direction)

    }
}
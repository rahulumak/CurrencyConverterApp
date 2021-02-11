package com.rahulumak.mobiquity.mobiquityassignment.ui.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.rahulumak.mobiquity.mobiquityassignment.databinding.FragmentMapBinding
import kotlinx.android.synthetic.main.fragment_map.view.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class MapFragment() : Fragment(), OnMapReadyCallback {

    private val mapViewModel: MapViewModel by viewModel { parametersOf() }
    private lateinit var root: View
    private lateinit var googleMap: GoogleMap
    private var localPermissionRequestCode = 1234;
    private var selectedLocationMarker: Marker? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMapBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.apply {
            lifecycleOwner = this@MapFragment
            viewModel = mapViewModel
        }

        root = binding.root

        root.mapView.onCreate(savedInstanceState)

        root.mapView.getMapAsync(this)


        root.fabAddBookmark.setOnClickListener {
            mapViewModel.addBookmark(requireContext()).observe(viewLifecycleOwner, {
                Toast.makeText(requireContext(), "Bookmark added.", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            })
        }

        return root
    }

    @SuppressLint("MissingPermission")
    fun getCurrentLocation() {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        fusedLocationClient.lastLocation.addOnSuccessListener {
            val sydney = LatLng(it.latitude, it.longitude)
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10f))
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        googleMap.uiSettings.isMyLocationButtonEnabled = true
        googleMap.uiSettings.isMapToolbarEnabled = false
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                localPermissionRequestCode
            )
            return
        } else {
            googleMap.isMyLocationEnabled = true
            getCurrentLocation()
        }

        val sydney = LatLng(18.5204, 73.8567)
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10f))

        googleMap.setOnMapClickListener {
            selectedLocationMarker?.remove()
            selectedLocationMarker = googleMap.addMarker(MarkerOptions().position(it))

            mapViewModel.isMarkerAdded.postValue(it)
        }
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == localPermissionRequestCode) {
            var gotPermission = true
            for (grantResult in grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    gotPermission = false
                    break
                }
            }

            if (!gotPermission) {
                Toast.makeText(
                    requireContext(),
                    "Permission denied. Some features will be disabled.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                googleMap.isMyLocationEnabled = true
            }
        }
    }

    override fun onStart() {
        super.onStart()
        root.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        root.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        root.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        root.mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        root.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        root.mapView.onLowMemory()
    }
}
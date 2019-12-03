package com.prevent.alertmap

import android.annotation.SuppressLint
import android.location.Criteria
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.prevent.alertmap.databinding.FragmentAlertMapBinding

class AlertMapFragment : Fragment() {

    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAlertMapBinding
            .inflate(
                LayoutInflater.from(requireContext()),
                container,
                true
            )

        val mapFragment = requireActivity().supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync {
            val map = it
            val locationManager = requireContext().getSystemService(LocationManager::class.java)
            if (locationManager != null) {
                val criteria = Criteria()
                    .apply {
                        this.accuracy = Criteria.ACCURACY_COARSE
                    }

                val bestProvider = locationManager.getBestProvider(criteria, true)
                val location = locationManager.getLastKnownLocation(bestProvider)
                if (location != null) {
                    map.animateCamera(
                        CameraUpdateFactory.newLatLngZoom(
                            LatLng(
                                location.latitude,
                                location.longitude
                            ),
                            15F
                        )
                    )
                }
            }
            it.isMyLocationEnabled = true
        }
        return binding.root
    }
}
package com.prevent.alertmap

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
            val sydney = LatLng(-34.0, 151.0)
            it.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        }
        return binding.root
    }
}
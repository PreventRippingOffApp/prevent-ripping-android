package com.prevent.alertmap

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.location.Criteria
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
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
        }

        binding.fragmentAlertMapDangerLevelSeekbar
            .setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
//                    Log.d("debug", (this@AlertMapFragment.view!!.height / 256 * progress).toString())


                    val animation = ValueAnimator
                        .ofInt(seekBar!!.layoutParams.height, this@AlertMapFragment.view!!.height / 256 * progress)
                    animation.addUpdateListener {
                        val animationValue = it.animatedValue as Int
                        val levelBarLayoutParams =
                            binding.fragmentAlertMapDangerLevelBar!!.layoutParams
                        levelBarLayoutParams.height = animationValue

                        binding.fragmentAlertMapDangerLevelBar.layoutParams =
                            levelBarLayoutParams
                    }
                    animation.start()
                }


                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            })

        return binding.root
    }
}
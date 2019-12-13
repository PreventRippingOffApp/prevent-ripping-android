package com.prevent.alertmap

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.prevent.alertmap.databinding.FragmentAlertMapBinding
import com.prevent.alertmap.service.MapService
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AlertMapFragment : Fragment() {

    private val viewModel: AlertMapViewModel by viewModel()
    private val mapService: MapService by inject (parameters = {
        parametersOf(requireActivity().supportFragmentManager
        .findFragmentById(R.id.map))
    })

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


        viewModel
            .currentLocationLiveData
            .observeForever {
                mapService.ZoomInTolocation(it)
            }

        binding.fragmentAlertMapDangerLevelSeekbar
            .setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        val animation = ValueAnimator
                            .ofInt(
                                binding.fragmentAlertMapDangerLevelBar!!.layoutParams.height,
                                this@AlertMapFragment.view!!.height / 256 * progress
                            )
                        animation.addUpdateListener {
                            val animationValue = it.animatedValue as Int
                            val levelBarLayoutParams =
                                binding.fragmentAlertMapDangerLevelBar.layoutParams
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
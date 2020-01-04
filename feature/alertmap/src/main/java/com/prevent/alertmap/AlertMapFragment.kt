package com.prevent.alertmap

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prevent.alertmap.databinding.FragmentAlertMapBinding
import com.prevent.alertmap.service.MapService
import com.prevent.util.VibrationService
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AlertMapFragment : Fragment() {

    private val viewModel: AlertMapViewModel by viewModel()
    private lateinit var binding: FragmentAlertMapBinding
    private val vibrationService: VibrationService by inject()
    private val alertmapNavigator: AlertmapNavigator by inject(parameters = { parametersOf(context) })

    private val mapService: MapService by inject(parameters = {
        parametersOf(
            requireActivity().supportFragmentManager
                .findFragmentById(R.id.map)
        )
    })

    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlertMapBinding
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

        viewModel
            .alertLevelLiveData
            .observeForever {
                val animation = ValueAnimator
                    .ofInt(
                        binding.fragmentAlertMapDangerLevelBar!!.layoutParams.height,
                        this@AlertMapFragment.view!!.height / 256 * it.alertLevel.value
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

        binding
            .fragmentAlertMapRecordFloatingActionButton
            .setOnClickListener {
                alertmapNavigator.navigateAlertScreen()
            }

        binding
            .fragmentAlertMapSettingImageView
            .setOnClickListener {
                vibrationService.playVibration()
                alertmapNavigator.naviatePreferenceScreen()
            }

        binding.fragmentAlertMapRecordLogImageView
            .setOnClickListener {
                vibrationService.playVibration()
                alertmapNavigator.showRecordLogDialog(parentFragmentManager)
            }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        viewModel.refreshAlertLevel()
    }
}

package com.prevent.alertmap

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prevent.alertmap.databinding.FragmentAlertMapBinding
import com.prevent.alertmap.service.MapService
import com.prevent.feature.record.dashboard.RecordDashboardActivity
import com.prevent.feature.record.domain.RecordService
import com.prevent.feature.record.list.RecordListDialog
import com.prevent.feature.setting.PreferenceActivity
import com.prevent.util.VibrationService
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AlertMapFragment : Fragment() {

    private val viewModel: AlertMapViewModel by viewModel()
    private lateinit var binding: FragmentAlertMapBinding

    private val recordService: RecordService by inject()
    private val vibrationService: VibrationService by inject()

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
                //                this.lifecycleScope.launch {
//                    val recordStatus = recordService.recordStatus
//                    try {
//                        when (recordStatus) {
//                            is RecordStatus.NotRecording -> recordService.startRecord()
//                            is RecordStatus.Recording -> recordService.stopRecord()
//                        }
//                    } finally {
//                        refreshRecordButtonText()
//                    }
//                }

                startActivity(
                    Intent(
                        context,
                        RecordDashboardActivity::class.java
                    )
                )
            }

        binding
            .fragmentAlertMapSettingImageView
            .setOnClickListener {
                vibrationService.playVibration()
                startActivity(
                    Intent(
                        requireContext(),
                        PreferenceActivity::class.java
                    )
                )
            }

        binding.fragmentAlertMapRecordLogImageView
            .setOnClickListener {
                vibrationService.playVibration()
                val dialog = RecordListDialog()
                dialog.showNow(parentFragmentManager, "tag")
            }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        viewModel.refreshAlertLevel()
    }

//    private fun refreshRecordButtonText() {
//        this.lifecycleScope.launch(Dispatchers.Main) {
//            launch(Dispatchers.Main) {
//                binding.fragmentAlertMapRecordFloatingActionButton.text =
//                    when (recordService.recordStatus) {
//                        is RecordStatus.Recording -> "録音中"
//                        is RecordStatus.NotRecording -> "録音する"
//                    }
//            }
//        }
//    }
}

package com.prevent.alertmap

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.prevent.alertmap.databinding.FragmentAlertMapBinding
import com.prevent.alertmap.service.MapService
import com.prevent.feature.record.domain.RecordService
import com.prevent.feature.record.domain.RecordStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AlertMapFragment : Fragment() {

    private val viewModel: AlertMapViewModel by viewModel()
    private lateinit var binding: FragmentAlertMapBinding

    private val recordService: RecordService by inject()

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



        binding
            .fragmentAlertMapRecordFloatingActionButton
            .setOnClickListener {
                this.lifecycleScope.launch {
                    val recordStatus = recordService.recordStatus
                    try {
                        when (recordStatus) {
                            is RecordStatus.notRecording -> recordService.startRecord()
                            is RecordStatus.recording -> recordService.stopRecord()
                        }
                    } finally {
                        refreshRecordButtonText()
                    }
                }
            }

        return binding.root
    }

    private fun refreshRecordButtonText() {
        this.lifecycleScope.launch(Dispatchers.Main) {
            launch(Dispatchers.Main) {
                binding.fragmentAlertMapRecordFloatingActionButton.text =
                    when (recordService.recordStatus) {
                        is RecordStatus.recording -> "録音中"
                        is RecordStatus.notRecording -> "録音停止する"
                    }
            }
        }
    }
}
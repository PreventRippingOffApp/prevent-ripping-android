package com.prevent.alertmap

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
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
import com.prevent.feature.record.list.RecordListDialog
import com.prevent.feature.setting.PreferenceActivity
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
                            is RecordStatus.NotRecording -> recordService.startRecord()
                            is RecordStatus.Recording -> recordService.stopRecord()
                        }
                    } finally {
                        refreshRecordButtonText()
                    }
                }
            }

        binding
            .fragmentAlertMapBottomNavigationView
            .menu
            .findItem(R.id.setting)
            .setOnMenuItemClickListener {
                startActivity(
                    Intent(
                        requireContext(),
                        PreferenceActivity::class.java
                    )
                )
                true
            }

        binding.fragmentAlertMapBottomNavigationView
            .menu
            .findItem(R.id.record_log)
            .setOnMenuItemClickListener {
                val dialog = RecordListDialog()
                dialog.showNow(parentFragmentManager, "tag")
                true
            }

        return binding.root
    }

    private fun refreshRecordButtonText() {
        this.lifecycleScope.launch(Dispatchers.Main) {
            launch(Dispatchers.Main) {
                binding.fragmentAlertMapRecordFloatingActionButton.text =
                    when (recordService.recordStatus) {
                        is RecordStatus.Recording -> "録音中"
                        is RecordStatus.NotRecording -> "録音する"
                    }
            }
        }
    }
}
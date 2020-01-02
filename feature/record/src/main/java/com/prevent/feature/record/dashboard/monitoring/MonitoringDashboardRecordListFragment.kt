package com.prevent.feature.record.dashboard.monitoring

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prevent.feature.record.databinding.FragmentMonitoringDashboardRecordListBinding

internal class MonitoringDashboardRecordListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            FragmentMonitoringDashboardRecordListBinding.inflate(
                layoutInflater,
                container,
                false
            )

        return binding.root
    }
}

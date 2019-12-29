package com.prevent.feature.record.dashboard.help

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.prevent.feature.record.R
import com.prevent.feature.record.databinding.ActivityRecordDashboardBinding

internal class RipOffMonitoringHelpActivity :
    FragmentActivity(R.layout.activity_rip_off_monitoring_help) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val binding =
            DataBindingUtil.setContentView<ActivityRecordDashboardBinding>(
                this,
                R.layout.activity_rip_off_monitoring_help
            )
    }
}

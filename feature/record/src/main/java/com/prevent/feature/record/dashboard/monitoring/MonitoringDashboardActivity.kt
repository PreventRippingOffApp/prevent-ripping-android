package com.prevent.feature.record.dashboard.monitoring

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.prevent.feature.record.R
import com.prevent.feature.record.databinding.ActivityMonitoringDashboardBinding

class MonitoringDashboardActivity : FragmentActivity(R.layout.activity_monitoring_dashboard) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        val binding = DataBindingUtil.setContentView<ActivityMonitoringDashboardBinding>(
            this,
            R.layout.activity_monitoring_dashboard
        )
    }
}

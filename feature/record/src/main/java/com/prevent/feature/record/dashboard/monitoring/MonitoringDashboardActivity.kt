package com.prevent.feature.record.dashboard.monitoring

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.prevent.feature.record.R
import kotlinx.android.synthetic.main.activity_monitoring_dashboard.activity_monitoring_dashboard_tab_layout
import kotlinx.android.synthetic.main.activity_monitoring_dashboard.activity_monitoring_dashboard_view_pager_2

class MonitoringDashboardActivity : FragmentActivity(R.layout.activity_monitoring_dashboard) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pagerAdapter = MonitoringDashboardPagerAdapter(this)
        activity_monitoring_dashboard_view_pager_2.adapter = pagerAdapter

        TabLayoutMediator(
            activity_monitoring_dashboard_tab_layout,
            activity_monitoring_dashboard_view_pager_2
        ) { tab: TabLayout.Tab, i: Int ->
            tab.text = pagerAdapter.fragmentName(i)
            tab.view.transitionName = pagerAdapter.getTabName(i)
        }.run {
            this.attach()
        }
    }
}

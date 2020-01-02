package com.prevent.feature.record.dashboard.monitoring

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

internal class MonitoringDashboardPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(
    fragmentActivity
) {
    private val fragmentList: List<Triple<Fragment, String, String>> = listOf(
        Triple(MonitoringDashboardTalkListFragment(), "トーク履歴", "talk"),
        Triple(MonitoringDashboardRecordListFragment(), "録音履歴", "record")
    )

    fun getTabName(position: Int): String {
        return fragmentList.elementAt(position).third
    }

    fun fragmentName(position: Int): String {
        return fragmentList.elementAt(position).second
    }

    override fun getItemCount(): Int {
        return fragmentList.count()
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList.elementAt(position).first
    }
}

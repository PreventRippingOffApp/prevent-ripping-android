package com.prevent.ripping.navigator

import androidx.fragment.app.FragmentManager
import com.prevent.feature.alert.SendAlertDialog
import com.prevent.feature.record.dashboard.RecordDashboardNavigator

class RecordDashboardNavigatorImpl : RecordDashboardNavigator {
    override fun showSendAlertDialog(fragmentManager: FragmentManager) {
        val dialog = SendAlertDialog()
        dialog.show(fragmentManager,"")
    }
}
package com.prevent.ripping.navigator

import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentManager
import com.prevent.alertmap.AlertmapNavigator
import com.prevent.feature.record.dashboard.RecordDashboardActivity
import com.prevent.feature.record.list.RecordListDialog
import com.prevent.feature.setting.PreferenceActivity

internal class AlertMapNavigatorimpl(
    private val context: Context
) : AlertmapNavigator {
    override fun showRecordLogDialog(fragmentManager: FragmentManager) {
        val dialog = RecordListDialog()
        dialog.showNow(fragmentManager, "")
    }

    override fun navigateAlertScreen() {
        context.startActivity(
            Intent(
                context,
                RecordDashboardActivity::class.java
            )
        )
    }

    override fun naviatePreferenceScreen() {
        context.startActivity(
            Intent(
                context,
                PreferenceActivity::class.java
            )
        )
    }
}


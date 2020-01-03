package com.prevent.alertmap

import androidx.fragment.app.FragmentManager

interface AlertmapNavigator {
    fun showRecordLogDialog(fragmentManager: FragmentManager)
    fun navigateAlertScreen()
    fun naviatePreferenceScreen()
}

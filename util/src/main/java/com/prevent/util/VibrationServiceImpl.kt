package com.prevent.util

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.core.content.getSystemService

internal class VibrationServiceImpl(
    private val context: Context
) : com.prevent.util.VibrationService {
    private val vibrator = context.getSystemService<Vibrator>()
    override fun playVibration() {
        vibrator?.let {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                val vibrationEffect =
                    VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE)
                vibrator.vibrate(vibrationEffect)
            } else {
                vibrator.vibrate(300)
            }
        }
    }
}
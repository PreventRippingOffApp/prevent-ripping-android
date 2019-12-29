package com.prevent.feature.record.location

import android.animation.LayoutTransition
import android.os.Bundle
import android.os.PersistableBundle
import android.view.animation.AccelerateInterpolator
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.prevent.feature.record.R
import com.prevent.feature.record.databinding.ActivityLocationLogBinding

class LocationLogActivity : FragmentActivity(R.layout.activity_location_log) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val binding = DataBindingUtil.setContentView<ActivityLocationLogBinding>(
            this,
            R.layout.activity_location_log
        )

        binding.map.transitionName = "map"
        binding.map.layoutTransition = LayoutTransition().apply {
            this.setInterpolator(LayoutTransition.APPEARING, AccelerateInterpolator())
        }
    }

    override fun onBackPressed() {
        ActivityCompat.finishAfterTransition(this)
    }
}
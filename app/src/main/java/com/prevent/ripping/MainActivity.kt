package com.prevent.ripping

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prevent.data.flags.Flags
import com.prevent.feature.walkthrough.WalkThroughActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val flags: Flags by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (flags.walkthroughShowed.not()) {
            showWalkthrough()
        }
    }

    private fun showWalkthrough() {
        val intent = Intent(
            applicationContext,
            WalkThroughActivity::class.java
        )

        finish()

        startActivity(
            intent
        )
    }
}

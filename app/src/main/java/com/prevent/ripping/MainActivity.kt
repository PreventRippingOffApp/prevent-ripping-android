package com.prevent.ripping

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prevent.feature.walkthrough.WalkThroughActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(
            Intent(
                applicationContext,
                WalkThroughActivity::class.java
            )
        )
    }
}

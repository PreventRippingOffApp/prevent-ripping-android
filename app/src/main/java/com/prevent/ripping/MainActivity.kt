package com.prevent.ripping

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prevent.alertmap.AlertMapFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        activity_main_navigate_to_map_button.setOnClickListener {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(
//                    R.id.activity_main_container_fragment,
//                    AlertMapFragment()
//                )
//                .commitNow()
//        }
    }
}

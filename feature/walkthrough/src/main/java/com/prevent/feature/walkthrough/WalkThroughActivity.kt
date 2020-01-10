package com.prevent.feature.walkthrough

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.prevent.data.flags.Flags
import kotlinx.android.synthetic.main.activity_walkthrough.activity_walkthrough_finish_button
import kotlinx.android.synthetic.main.activity_walkthrough.activity_walkthrough_progress_bar
import kotlinx.android.synthetic.main.activity_walkthrough.activity_walkthrough_view_pager_2
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WalkThroughActivity : FragmentActivity(R.layout.activity_walkthrough) {

    private val walkthroughNavigator: WalkthroughNavigator by inject()
    private val walkThroughViewModel: WalkThroughViewModel by viewModel()
    private val flags: Flags by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pageradapter = WalkThroughPagerAdapter(this) {
            activity_walkthrough_view_pager_2.currentItem =
                activity_walkthrough_view_pager_2.currentItem + 1
        }
        activity_walkthrough_view_pager_2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                walkThroughViewModel.pageChanged(
                    pageradapter,
                    position
                )
                activity_walkthrough_finish_button.visibility = if (position == 2) {
                    View.VISIBLE
                } else {
                    View.GONE
                }

                // disable on input user information page.
                activity_walkthrough_view_pager_2.isUserInputEnabled = position != 1
            }
        })
        activity_walkthrough_finish_button
            .setOnClickListener {
                flags.walkthroughShowed = true
                val mainScreen = walkthroughNavigator.getMainScreen()
                val intent = Intent(applicationContext, mainScreen.javaClass)
                startActivity(
                    intent
                )
            }

        walkThroughViewModel.pageChanged(
            pageradapter,
            0
        )

        walkThroughViewModel
            .walkThroughLiveData
            .observeForever {
                activity_walkthrough_progress_bar.progress = it.progress
            }
        activity_walkthrough_view_pager_2.adapter = pageradapter
    }
}

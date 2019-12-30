package com.prevent.feature.walkthrough

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.prevent.feature.walkthrough.databinding.ActivityWalkthroughBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WalkThroughActivity : FragmentActivity(R.layout.activity_walkthrough) {

    private val walkThroughViewModel: WalkThroughViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityWalkthroughBinding>(
            this,
            R.layout.activity_walkthrough
        )

        val pageradapter = WalkThroughPagerAdapter(this) {
            binding.activityWalkthroughViewPager2.currentItem =
                binding.activityWalkthroughViewPager2.currentItem + 1
        }
        binding.activityWalkthroughViewPager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                walkThroughViewModel.pageChanged(
                    pageradapter,
                    position
                )
                // disable on input user information page.
                binding.activityWalkthroughViewPager2.isUserInputEnabled = position != 1
            }
        })
        walkThroughViewModel.pageChanged(
            pageradapter,
            0
        )
        walkThroughViewModel
            .walkThroughLiveData
            .observeForever {
                binding.viewEntity = it
            }
        binding.activityWalkthroughViewPager2.adapter = pageradapter
    }
}

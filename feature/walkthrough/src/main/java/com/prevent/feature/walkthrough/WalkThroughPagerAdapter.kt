package com.prevent.feature.walkthrough

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.prevent.feature.walkthrough.info.WalkThroughRegisterPersonalInfoFragment

internal class WalkThroughPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val nextPage: (() -> Unit)
) : FragmentStateAdapter(fragmentActivity) {

    val fragmentList = listOf(
        WalkThroughWelcomeFragment(),
        WalkThroughRegisterPersonalInfoFragment(nextPage),
        WalkThroughFinishFragment()
    )

    override fun getItemCount(): Int {
        return fragmentList.count()
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList.elementAt(position)
    }
}

package com.prevent.ripping.navigator

import android.app.Activity
import com.prevent.feature.walkthrough.WalkthroughNavigator
import com.prevent.ripping.MainActivity

internal class WalkthroughNavigatorImpl : WalkthroughNavigator {
    override fun getMainScreen(): Activity {
        return MainActivity()
    }
}

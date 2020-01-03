package com.prevent.ripping.navigator

import android.content.Context
import com.prevent.alertmap.AlertmapNavigator
import com.prevent.feature.walkthrough.WalkthroughNavigator
import org.koin.dsl.module

internal val navigatorModule = module {
    factory { WalkthroughNavigatorImpl() as WalkthroughNavigator }
    factory { (context: Context) -> AlertMapNavigatorimpl(context) as AlertmapNavigator }
}

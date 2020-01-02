package com.prevent.ripping.navigator

import com.prevent.feature.walkthrough.WalkthroughNavigator
import org.koin.dsl.module

internal val navigatorModule = module {
    factory { WalkthroughNavigatorImpl() as WalkthroughNavigator }
}

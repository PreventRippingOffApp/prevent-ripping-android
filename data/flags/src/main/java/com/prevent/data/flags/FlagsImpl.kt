package com.prevent.data.flags

import android.content.Context
import com.prevent.util.PreferenceProperty

internal class FlagsImpl(context: Context) : Flags {

    override var walkthroughShowed: Boolean by PreferenceProperty(
        context,
        "walkthrough_shows_preference",
        false
    )
}

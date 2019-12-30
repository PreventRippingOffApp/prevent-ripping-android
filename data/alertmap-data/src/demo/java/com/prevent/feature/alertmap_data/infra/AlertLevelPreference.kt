package com.prevent.feature.alertmap_data.infra

import android.content.Context
import com.prevent.alertmap_data.feature.entity.AlertLevelEntity
import com.prevent.util.PreferenceContainer

internal class AlertLevelPreference(
    override val context: Context
) : PreferenceContainer<AlertLevelEntity> {
    override val key: String = "AlertLevelPreference"
}

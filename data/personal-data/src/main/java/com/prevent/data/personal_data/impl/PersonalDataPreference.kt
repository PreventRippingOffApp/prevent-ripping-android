package com.prevent.data.personal_data.impl

import android.content.Context
import com.prevent.data.personal_data.entity.PersonalDataEntity
import com.prevent.util.PreferenceContainer

internal class PersonalDataPreference(override val context: Context) :
    PreferenceContainer<PersonalDataEntity> {
    override val key: String
        get() = "personal_data_preference"
}

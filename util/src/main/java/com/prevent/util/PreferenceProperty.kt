package com.prevent.util

import android.content.Context
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class PreferenceProperty<T : Any>(
    private val context: Context,
    val preferenceKey: String,
    private val defaultValue: T
) {
    private val preference = object : PreferenceContainer<T> {
        override val context: Context
            get() = this@PreferenceProperty.context
        override val key: String
            get() = this@PreferenceProperty.preferenceKey
        override val type: KClass<out T>
            get() = defaultValue::class
    }

    operator fun getValue(target: Any, property: KProperty<*>): T {
        return preference.loadData(defaultValue)
    }

    operator fun setValue(target: Any, property: KProperty<*>, b: T) {
        preference.storeData(b)
    }
}

package com.prevent.feature.alertmap_data.infra

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface PreferenceContainer<T : Any> {
    val context: Context
    val key: String

    fun preference(): SharedPreferences =
        context.getSharedPreferences(key, Context.MODE_PRIVATE)
}

inline fun <reified T : Any> getClassKey(): String {
    return T::class.qualifiedName ?: T::class.java.name
}

inline fun <reified T : Any> PreferenceContainer<T>.loadData(
    default: T? = null
): T? {
    val json = preference().getString(getClassKey<T>(), "")
    return Gson().fromJson(json, object : TypeToken<T>() {}.type) ?: default
}

inline fun <reified T : Any> PreferenceContainer<T>.storeData(value: T) {
    val json = Gson().toJson(value)
    preference()
        .edit()
        .apply {
            this.putString(
                getClassKey<T>(),
                json
            )
            this.commit()
        }
}

inline fun <reified T : Any> PreferenceContainer<T>.updateData(lambda: ((T?) -> T)) {
    this.storeData(
        lambda(
            this.loadData()
        )
    )
}

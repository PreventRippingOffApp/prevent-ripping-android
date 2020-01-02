package com.prevent.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.reflect.KClass

interface PreferenceContainer<T : Any> {
    val context: Context
    val key: String
    val type: KClass<out T>

    companion object {
        fun <T : Any> of(
            context: Context,
            key: String,
            type: KClass<T>
        ): PreferenceContainer<T> {
            return object : PreferenceContainer<T> {
                override val context: Context
                    get() = context
                override val key: String
                    get() = key
                override val type: KClass<out T>
                    get() = type
            }
        }
    }

    fun preference(): SharedPreferences =
        context.getSharedPreferences(key, Context.MODE_PRIVATE)

    fun <T : Any> getClassKey(): String {
        return type.qualifiedName ?: type.java.name
    }

    fun <T : Any> loadData(): T? {
        val json = preference().getString(getClassKey<T>(), "")
        return Gson().fromJson(json, object : TypeToken<T>() {}.type)
    }

    fun <T : Any> loadData(
        default: T
    ): T {
        val json = preference().getString(getClassKey<T>(), "")
        return Gson().fromJson(json, object : TypeToken<T>() {}.type) ?: default
    }

    @SuppressLint("ApplySharedPref")
    fun <T : Any> storeData(value: T) {
        val json = Gson().toJson(value)
        preference()
            .edit()
            .apply {
                this.putString(
                    getClassKey<T>(),
                    json
                )
            }.commit()
    }
}

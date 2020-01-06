package com.prevent.feature.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SeekBarPreference
import androidx.preference.SwitchPreference
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.domain.AlertLevelRepository
import com.prevent.alertmap_data.feature.entity.AlertLevelEntity
import com.prevent.alertmap_data.feature.entity.LocationEntity
import com.prevent.alertmap_data.feature.entity.valueobject.AlertlevelValueObject
import com.prevent.data.flags.Flags
import org.koin.android.ext.android.inject
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PreferenceRootFragment : PreferenceFragmentCompat() {

    private val alertLevelRepository: AlertLevelRepository by inject()
    private val alertlevelReadonlyRepository: AlertLevelReadonlyRepository by inject()
    private val preferenceRootFragmentViewModel: PreferenceRootFragmentViewModel by viewModel()
    private val flags: Flags by inject()

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.main_preference, rootKey)

        val preferenceCategory = PreferenceCategory(
            preferenceScreen.context
        ).apply {
            title = "カテゴリーネーム"
        }

        preferenceScreen.addPreference(preferenceCategory)

        val preference = Preference(
            preferenceScreen.context
        ).apply {
            title = "Title"
            setOnPreferenceClickListener {
                Toast.makeText(requireContext(), "title1", Toast.LENGTH_SHORT).show()
                true
            }
        }

        preferenceCategory.addPreference(preference)

        val preference2 = Preference(
            preferenceScreen.context
        ).apply {
            title = "Title"
            setOnPreferenceClickListener {
                Toast.makeText(requireContext(), "title2", Toast.LENGTH_SHORT).show()
                true
            }
        }

        preferenceCategory.addPreference(preference2)

        val aboutDeveloperCategory = PreferenceCategory(preferenceScreen.context)
            .apply {
                title = "開発者について"
            }
        preferenceScreen.addPreference(aboutDeveloperCategory)

        val aboutDeveloperPreference = Preference(
            preferenceScreen.context
        ).apply {
            title = "開発者について"
            setOnPreferenceClickListener {
                preferenceRootFragmentViewModel.showAboutDeveloperScreen()
                true
            }
        }
        aboutDeveloperCategory.addPreference(aboutDeveloperPreference)
        val licensePreferenceCategory = PreferenceCategory(preferenceScreen.context)
            .also { preferenceScreen.addPreference(it) }
            .apply {
                title = "ライセンス情報"
            }

        val licensePreference = Preference(preferenceScreen.context).apply {
            title = "ライセンス情報を見る"
            setOnPreferenceClickListener {
                startActivity(
                    Intent(
                        context,
                        OssLicensesMenuActivity::class.java

                    )
                )
                true
            }
        }
        licensePreferenceCategory.addPreference(licensePreference)

        if (BuildConfig.BUILD_TYPE == "debug") {
            val debugSettingCategory = PreferenceCategory(
                preferenceScreen.context
            )
                .also { preferenceScreen.addPreference(it) }
                .apply {
                    title = "デバッグ設定"
                }

            fun <T : Any> KClass<T>.toMemberProperties(): List<KProperty1<Flags, Any>> =
                this.memberProperties.filter { it is KProperty1<*, *> }.map { it as KProperty1<Flags, Any> }

            fun <R> KProperty1<Flags, R>.toPreference(
                context: Context
            ): Preference {
                val value = this.get(flags)
                val name = this.name
                return when (value) {
                    is Boolean -> {
                        SwitchPreference(context)
                            .apply {
                                title = name
                                isChecked = value
                                setOnPreferenceClickListener {
                                    val property =
                                        flags::class.toMemberProperties().first { it.name == name }

                                    if (property is KMutableProperty<*>) {
                                        property.setter.call(flags, this.isChecked)
                                    }

                                    true
                                }
                            }
                    }
                    else -> {
                        Preference(context)
                    }
                }
            }

            flags::class
                .toMemberProperties()
                .forEach {
                    debugSettingCategory.addPreference(it.toPreference(preferenceScreen.context))
                }

            val alertLevelPreference = SeekBarPreference(preferenceScreen.context)
                .apply {
                    title = "危険度設定"
                    showSeekBarValue = true
                    max = 255
                    min = 0
                    summary = "ダッシュボード画面で表示する危険度です。"
                    setOnPreferenceClickListener {
                        true
                    }
                    value = alertlevelReadonlyRepository.readAlertLevel(LocationEntity.default())
                        .alertlevelValueObject.value

                    this.setOnPreferenceChangeListener { preference, newValue ->
                        val entity = AlertLevelEntity(
                            0,
                            AlertlevelValueObject.create(newValue as Int)
                        )
                        alertLevelRepository.storeAlertLevel(
                            entity
                        )
                        true
                    }
                }
            debugSettingCategory.addPreference(alertLevelPreference)
        }
    }
}

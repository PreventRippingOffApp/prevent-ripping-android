package com.prevent.feature.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.preference.Preference
import androidx.preference.PreferenceCategory
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SeekBarPreference
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.domain.AlertLevelRepository
import com.prevent.alertmap_data.feature.entity.AlertLevelEntity
import com.prevent.alertmap_data.feature.entity.LocationEntity
import com.prevent.alertmap_data.feature.entity.valueobject.AlertlevelValueObject
import org.koin.android.ext.android.inject

class PreferenceRootFragment : PreferenceFragmentCompat() {

    private val alertLevelRepository: AlertLevelRepository by inject()
    private val alertlevelReadonlyRepository: AlertLevelReadonlyRepository by inject()

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

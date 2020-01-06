package com.prevent.feature.setting.infra

import android.content.Context
import android.content.Intent
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import com.prevent.feature.setting.domain.ShowAboutDeveloperUsecase

internal class ShowAboutDeveloperUsecaseImpl(
    private val context: Context
) : ShowAboutDeveloperUsecase {
    override suspend fun execute() {
        val customTabsIntent = CustomTabsIntent.Builder().enableUrlBarHiding().build()
        val pageUrl = "https://sechack365.nict.go.jp/"
        customTabsIntent.launchUrl(context, pageUrl.toUri())
        context.startActivity(
            customTabsIntent.intent.apply {
                data = pageUrl.toUri()
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
        )
    }
}

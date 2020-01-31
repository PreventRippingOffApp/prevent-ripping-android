package com.prevent.feature.record.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.SupportMapFragment
import com.prevent.feature.record.R
import com.prevent.feature.record.dashboard.help.RipOffMonitoringHelpActivity
import com.prevent.feature.record.dashboard.monitoring.MonitoringDashboardActivity
import com.prevent.feature.record.list.RecordListDialog
import com.prevent.feature.record.location.LocationLogActivity
import com.prevent.feature.record.talk.list.TalkListDialog
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_alert_with_mail_button
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_card_view_title_text_view
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_location_log_card_view
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_record_card_view
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_rip_off_monitoring_help_image_view
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_rip_off_records_material_text_button
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_rip_off_talk_material_text_button
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_show_all_material_button
import kotlinx.android.synthetic.main.activity_record_dashboard.map
import org.koin.android.ext.android.inject

class RecordDashboardActivity : FragmentActivity(R.layout.activity_record_dashboard) {

    private val recordDashboardNavigator:RecordDashboardNavigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity_record_dashboard_rip_off_records_material_text_button
            .setOnClickListener {
                val dialog = RecordListDialog()
                dialog.show(supportFragmentManager, "")
            }

        activity_record_dashboard_alert_with_mail_button
            .setOnClickListener {
                recordDashboardNavigator.showSendAlertDialog(supportFragmentManager)
            }

        activity_record_dashboard_rip_off_talk_material_text_button
            .setOnClickListener {
                val dialog = TalkListDialog()
                dialog.show(supportFragmentManager, "")
            }

        activity_record_dashboard_show_all_material_button.setOnClickListener { navigateLocationLogActivity() }
        activity_record_dashboard_location_log_card_view.setOnClickListener { navigateLocationLogActivity() }

        // navigate to Location Log Activity, when a reaction to map view
        (map as SupportMapFragment).getMapAsync {
            it.setOnMapClickListener {
                navigateLocationLogActivity()
            }
            it.setOnCameraMoveStartedListener {
                navigateLocationLogActivity()
            }
            it.setOnMapLongClickListener {
                navigateLocationLogActivity()
            }
        }

        activity_record_dashboard_rip_off_monitoring_help_image_view
            .setOnClickListener {
                startActivity(
                    Intent(
                        applicationContext,
                        RipOffMonitoringHelpActivity::class.java
                    )
                )
            }

        activity_record_dashboard_record_card_view
            .setOnClickListener {
                startActivity(
                    Intent(
                        applicationContext,
                        MonitoringDashboardActivity::class.java
                    )
                )
            }
    }

    private fun navigateLocationLogActivity() {
        val transitionOption = ActivityOptionsCompat
            .makeSceneTransitionAnimation(
                this,
                Pair<View, String>(
                    map.view!!,
                    "map"
                ),
                Pair<View, String>(
                    activity_record_dashboard_card_view_title_text_view,
                    "title_text"
                ),
                Pair<View, String>(
                    activity_record_dashboard_location_log_card_view,
                    "container"
                )
            )

        startActivity(
            Intent(
                applicationContext,
                LocationLogActivity::class.java
            ),
            transitionOption.toBundle()
        )
    }
}

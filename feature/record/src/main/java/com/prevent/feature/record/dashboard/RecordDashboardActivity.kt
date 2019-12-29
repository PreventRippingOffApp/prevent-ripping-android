package com.prevent.feature.record.dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.prevent.feature.record.R
import com.prevent.feature.record.list.RecordListDialog
import com.prevent.feature.record.talk.list.TalkListDialog
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_alert_with_mail_button
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_rip_off_records_material_text_button
import kotlinx.android.synthetic.main.activity_record_dashboard.activity_record_dashboard_rip_off_talk_material_text_button

class RecordDashboardActivity : FragmentActivity(R.layout.activity_record_dashboard) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity_record_dashboard_rip_off_records_material_text_button
            .setOnClickListener {
                val dialog = RecordListDialog()
                dialog.show(supportFragmentManager, "")
            }

        activity_record_dashboard_alert_with_mail_button
            .setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_SENDTO
                    ).apply {
                        type = "*/*"
                        data = Uri.parse("mailto:")
                        putExtra(Intent.EXTRA_EMAIL, arrayOf("info@contso.com"))
                        putExtra(Intent.EXTRA_SUBJECT, "通報について")
                        putExtra(Intent.EXTRA_TEXT, "通報について")
                    }
                )
            }

        activity_record_dashboard_rip_off_talk_material_text_button
            .setOnClickListener {
                val dialog = TalkListDialog()
                dialog.show(supportFragmentManager, "")
            }
    }
}
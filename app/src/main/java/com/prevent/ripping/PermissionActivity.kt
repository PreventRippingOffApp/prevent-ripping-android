package com.prevent.ripping

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import permissions.dispatcher.*

@RuntimePermissions
class PermissionActivity : AppCompatActivity(R.layout.activity_permission) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        moveNowLocationWithPermissionCheck()
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }

    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun moveNowLocation() {

    }

    @OnShowRationale(Manifest.permission.ACCESS_FINE_LOCATION)
    fun showLocationRationale(request: PermissionRequest) {
    }

    @OnPermissionDenied(Manifest.permission.ACCESS_FINE_LOCATION)
    fun onLocationPermissionDenied() {

    }

    @OnNeverAskAgain(Manifest.permission.ACCESS_FINE_LOCATION)
    fun onLocationPermssionNeverAsAgain() {

    }
}
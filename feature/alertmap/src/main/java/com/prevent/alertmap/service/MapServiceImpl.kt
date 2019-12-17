package com.prevent.alertmap.service

import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.prevent.alertmap.entity.CurrentLocationEntity

internal class MapServiceImpl(
    private val fragment: Fragment
) : MapService {

    override fun ZoomInTolocation(locationEntity: CurrentLocationEntity) {
        if (fragment is SupportMapFragment) {
            val supportMapFragment = fragment
            supportMapFragment.getMapAsync {
                it.animateCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        LatLng(
                            locationEntity.location.lat.value,
                            locationEntity.location.lon.value
                        ),
                        15F
                    )
                )
            }
        }
    }
}

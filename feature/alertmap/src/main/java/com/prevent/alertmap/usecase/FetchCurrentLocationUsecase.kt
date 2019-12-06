package com.prevent.alertmap.usecase

import com.prevent.alertmap.entity.CurrentLocationEntity

internal interface FetchCurrentLocationUsecase {
    fun execute(): CurrentLocationEntity
}
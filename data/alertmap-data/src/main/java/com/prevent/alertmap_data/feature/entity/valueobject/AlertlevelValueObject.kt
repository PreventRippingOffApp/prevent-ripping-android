package com.prevent.alertmap_data.feature.entity.valueobject

import java.security.InvalidParameterException

class AlertlevelValueObject private constructor(
    val value: Int
) {
    companion object {

        fun default(): AlertlevelValueObject {
            return AlertlevelValueObject(0)
        }

        fun create(value: Int): AlertlevelValueObject {
            if (0 < value && value < 256) {
                return AlertlevelValueObject(value)
            } else {
                throw InvalidParameterException("$value is invalid for AlertLevel")
            }
        }
    }
}
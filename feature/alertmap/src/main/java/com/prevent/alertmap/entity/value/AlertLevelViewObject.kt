package com.prevent.alertmap.entity.value

internal class AlertLevelViewObject private constructor(
    val value: Int
) {
    companion object {
        fun create(value: Int): AlertLevelViewObject {
            if (value < 0 || 255 < value) {
                throw IllegalArgumentException()
            }
            return AlertLevelViewObject(
                value
            )
        }
    }
}
package com.prevent.feature.setting.domain

import android.content.Context
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.Fragment
import java.util.concurrent.Executor
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal class BiometricServiceImpl(
    context: Context
) : BiometricService {
    private val biometricManager: BiometricManager = BiometricManager.from(context)

    override suspend fun auth(fragment: Fragment) = suspendCoroutine<BiometricState> {
        val continuation = it
        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                it.resume(BiometricState.NoHardware)
            }
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                it.resume(BiometricState.NoEnrolled)
            }
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                it.resume(BiometricState.HardwareEnable)
            }
            else -> {
                val promptInfo = BiometricPrompt
                    .PromptInfo
                    .Builder()
                    .setTitle("個人情報の編集をします")
                    .setSubtitle("安全に編集するた生体認証をします")
                    .setDeviceCredentialAllowed(true)
                    .build()

                val biometricPrompt = BiometricPrompt(
                    fragment,
                    Executor {
                        it.run()
                    },
                    object : BiometricPrompt.AuthenticationCallback() {
                        override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                            super.onAuthenticationSucceeded(result)
                            continuation.resume(BiometricState.Success)
                        }

                        override fun onAuthenticationError(
                            errorCode: Int,
                            errString: CharSequence
                        ) {
                            super.onAuthenticationError(errorCode, errString)
                            continuation.resume(BiometricState.Failed(errString.toString()))
                        }

                        override fun onAuthenticationFailed() {
                            super.onAuthenticationFailed()

                            continuation.resume(BiometricState.Denied)
                        }
                    }
                )

                biometricPrompt.authenticate(promptInfo)
            }
        }
    }
}

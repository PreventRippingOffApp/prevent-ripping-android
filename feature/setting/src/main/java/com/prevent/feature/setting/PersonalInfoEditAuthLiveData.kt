package com.prevent.feature.setting

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.prevent.feature.setting.domain.BiometricService
import com.prevent.feature.setting.domain.BiometricState
import com.prevent.feature.setting.state.PersonalInfoEditAuthState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class PersonalInfoEditAuthLiveData(
    private val biometricService: BiometricService,
    private val coroutineScope: CoroutineScope
) : LiveData<PersonalInfoEditAuthState>() {
    fun auth(fragment: Fragment) {
        coroutineScope.launch(Dispatchers.Main) {
            kotlin.runCatching { biometricService.auth(fragment) }
                .onFailure {
                    postValue(PersonalInfoEditAuthState.failed("例外が発生しました ${it.message}"))
                }
                .onSuccess {
                    postValue(
                        when (it) {
                            BiometricState.Success -> PersonalInfoEditAuthState.success
                            is BiometricState.Failed -> PersonalInfoEditAuthState.failed("認証に失敗しました")
                            BiometricState.Denied -> PersonalInfoEditAuthState.failed("拒否されました")
                            BiometricState.NoEnrolled -> PersonalInfoEditAuthState.failed("生体認証が設定されていません")
                            BiometricState.unknow -> PersonalInfoEditAuthState.failed("生体認証に失敗しました")
                            BiometricState.NoHardware -> PersonalInfoEditAuthState.failed("ハードウェアが生体認証に対応していません")
                            BiometricState.HardwareEnable -> PersonalInfoEditAuthState.failed("ハードウェアが無効化されています")
                        }
                    )
                }
        }
    }
}

package com.prevent.feature.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prevent.feature.setting.domain.ShowAboutDeveloperUsecase
import kotlinx.coroutines.launch

internal class PreferenceRootFragmentViewModel(
    private val showAboutDeveloperUsecase: ShowAboutDeveloperUsecase
) : ViewModel() {
    fun showAboutDeveloperScreen() {
        viewModelScope.launch {
            showAboutDeveloperUsecase.execute()
        }
    }
}

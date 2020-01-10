package com.prevent.feature.setting

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prevent.feature.setting.domain.ShowAboutDeveloperUsecase
import com.prevent.feature.setting.state.PersonalInfoEditAuthState
import kotlinx.coroutines.launch

internal class PreferenceRootFragmentViewModel(
    private val showAboutDeveloperUsecase: ShowAboutDeveloperUsecase,
    personalInfoEditAuthLiveDataFactory: PersonalInfoEditAuthLiveDataFactory
) : ViewModel() {

    private val _personalInfoEditAuthLiveData: PersonalInfoEditAuthLiveData =
        personalInfoEditAuthLiveDataFactory.create(viewModelScope)
    val personalInfoEditAuthLiveData: LiveData<PersonalInfoEditAuthState> =
        _personalInfoEditAuthLiveData

    fun showAboutDeveloperScreen() {
        viewModelScope.launch {
            showAboutDeveloperUsecase.execute()
        }
    }

    fun showPersonalInfoScreen(fragment: Fragment) {
        _personalInfoEditAuthLiveData.auth(fragment)
    }
}

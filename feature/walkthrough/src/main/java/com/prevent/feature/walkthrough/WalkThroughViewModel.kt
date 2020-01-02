package com.prevent.feature.walkthrough

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prevent.feature.walkthrough.viewentity.WalkthroughViewEntity

internal class WalkThroughViewModel : ViewModel() {

    private val _walkThroughLiveData: MutableLiveData<WalkthroughViewEntity> = MutableLiveData()
    val walkThroughLiveData: LiveData<WalkthroughViewEntity> = _walkThroughLiveData

    fun pageChanged(
        walkThroughPagerAdapter: WalkThroughPagerAdapter,
        position: Int
    ) {
        _walkThroughLiveData.postValue(
            WalkthroughViewEntity(
                100 / walkThroughPagerAdapter.itemCount * (position + 1)
            )
        )
    }
}


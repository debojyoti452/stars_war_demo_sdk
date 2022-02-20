package com.example.mvvm_app.features.vms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_app.utils.enums.NavEnum

class NavigationViewModel : ViewModel() {

    private val _screenValue = MutableLiveData<NavEnum>()
    val screenValue: LiveData<NavEnum> = _screenValue

    fun screenChange(screenEnums: NavEnum) {
        _screenValue.value = screenEnums
    }
}

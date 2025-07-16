package com.aniwallshq.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aniwallshq.data.local.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    val isDarkTheme = dataStoreManager.isDarkTheme
        .stateIn(viewModelScope, SharingStarted.Lazily, false)

    fun setTheme(isDark: Boolean) {
        viewModelScope.launch {
            dataStoreManager.setTheme(isDark)
        }
    }
}

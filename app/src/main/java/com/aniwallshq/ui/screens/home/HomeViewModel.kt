package com.aniwallshq.ui.screens.home

import androidx.lifecycle.ViewModel
import com.aniwallshq.data.WallpaperRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WallpaperRepository
) : ViewModel() {
    // The state for the home screen will be managed here.
}

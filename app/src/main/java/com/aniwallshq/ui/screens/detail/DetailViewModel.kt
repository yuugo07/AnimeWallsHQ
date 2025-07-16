package com.aniwallshq.ui.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aniwallshq.data.WallpaperRepository
import com.aniwallshq.data.local.model.WallpaperEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: WallpaperRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _wallpaper = MutableStateFlow<WallpaperEntity?>(null)
    val wallpaper: StateFlow<WallpaperEntity?> = _wallpaper.asStateFlow()

    init {
        savedStateHandle.get<String>("wallpaperId")?.let { wallpaperId ->
            viewModelScope.launch {
                // This is not efficient, but for now, we'll get all wallpapers and find the one we need.
                // A better approach would be to have a specific query in the DAO.
                repository.getWallpapers().collect { wallpapers ->
                    _wallpaper.value = wallpapers.find { it.messageId.toString() == wallpaperId }
                }
            }
        }
    }
}

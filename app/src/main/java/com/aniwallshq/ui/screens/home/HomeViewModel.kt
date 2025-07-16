package com.aniwallshq.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aniwallshq.data.WallpaperRepository
import com.aniwallshq.data.local.model.WallpaperEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WallpaperRepository
) : ViewModel() {

    private val _wallpapers = MutableStateFlow<List<WallpaperEntity>>(emptyList())
    val wallpapers: StateFlow<List<WallpaperEntity>> = _wallpapers.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init {
        observeWallpapers()
        fetchWallpapers()
    }

    private fun observeWallpapers() {
        repository.getWallpapers().onEach {
            _wallpapers.value = it
        }.launchIn(viewModelScope)
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        if (query.isEmpty()) {
            observeWallpapers()
        } else {
            repository.searchWallpapers(query).onEach {
                _wallpapers.value = it
            }.launchIn(viewModelScope)
        }
    }

    fun fetchWallpapers(offset: Int = 0) {
        viewModelScope.launch {
            repository.fetchAndCacheWallpapers(offset)
        }
    }
}

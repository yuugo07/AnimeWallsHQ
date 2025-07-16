package com.aniwallshq.data

import com.aniwallshq.data.local.dao.WallpaperDao
import com.aniwallshq.data.remote.ApiService
import javax.inject.Inject

class WallpaperRepository @Inject constructor(
    private val apiService: ApiService,
    private val wallpaperDao: WallpaperDao
) {
    // The implementation of data fetching and caching will be added here later.
}

package com.yuugo.animewallshq.data

import com.yuugo.animewallshq.data.local.dao.WallpaperDao
import com.yuugo.animewallshq.data.remote.ApiService
import javax.inject.Inject

class WallpaperRepository @Inject constructor(
    private val apiService: ApiService,
    private val wallpaperDao: WallpaperDao
) {
    // The repository logic will be implemented in a later phase.
}

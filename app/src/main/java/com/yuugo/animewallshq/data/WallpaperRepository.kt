package com.yuugo.animewallshq.data

import com.yuugo.animewallshq.BuildConfig
import com.yuugo.animewallshq.data.local.dao.WallpaperDao
import com.yuugo.animewallshq.data.local.model.WallpaperEntity
import com.yuugo.animewallshq.data.remote.ApiService
import com.yuugo.animewallshq.data.remote.model.Message
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WallpaperRepository @Inject constructor(
    private val apiService: ApiService,
    private val wallpaperDao: WallpaperDao
) {

    fun getWallpapers(): Flow<List<WallpaperEntity>> = wallpaperDao.getWallpapers()

    suspend fun fetchWallpapers(offset: Int, limit: Int = 20) {
        try {
            val response = apiService.getWallpapers(
                chatId = BuildConfig.TELEGRAM_CHANNEL_ID,
                offset = offset,
                limit = limit
            )
            if (response.isSuccessful) {
                response.body()?.let {
                    val wallpapers = it.result.mapNotNull { message ->
                        messageToWallpaperEntity(message)
                    }
                    wallpaperDao.insertAll(wallpapers)
                }
            }
        } catch (e: Exception) {
            // Handle exceptions
        }
    }

    fun searchWallpapers(query: String): Flow<List<WallpaperEntity>> {
        return wallpaperDao.searchByAnimeName(query)
    }

    private fun messageToWallpaperEntity(message: Message): WallpaperEntity? {
        val photo = message.photo?.lastOrNull() ?: return null
        val caption = message.caption ?: "Unknown"
        return WallpaperEntity(
            messageId = message.messageId,
            previewUrl = photo.fileId, // Using fileId as a placeholder for now
            fullImageUrl = photo.fileId, // Using fileId as a placeholder for now
            animeName = caption
        )
    }
}

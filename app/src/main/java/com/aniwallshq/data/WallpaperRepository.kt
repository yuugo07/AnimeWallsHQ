package com.aniwallshq.data

import com.aniwallshq.data.local.dao.WallpaperDao
import com.aniwallshq.data.remote.ApiService
import com.aniwallshq.data.local.model.WallpaperEntity
import kotlinx.coroutines.flow.Flow
import java.util.regex.Pattern
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WallpaperRepository @Inject constructor(
    private val apiService: ApiService,
    private val wallpaperDao: WallpaperDao
) {

    fun getWallpapers(): Flow<List<WallpaperEntity>> = wallpaperDao.getWallpapers()

    fun searchWallpapers(query: String): Flow<List<WallpaperEntity>> = wallpaperDao.searchByAnimeName(query)

    suspend fun fetchAndCacheWallpapers(offset: Int) {
        try {
            val response = apiService.getWallpapers(offset)
            val wallpapers = response.result.mapNotNull { message ->
                if (message.photo != null && message.caption != null) {
                    val animeName = extractAnimeName(message.caption)
                    if (animeName != null) {
                        val previewUrl = getFileUrl(message.photo.first().fileId)
                        val fullImageUrl = getFileUrl(message.photo.last().fileId)
                        WallpaperEntity(
                            messageId = message.messageId,
                            previewUrl = previewUrl,
                            fullImageUrl = fullImageUrl,
                            animeName = animeName
                        )
                    } else {
                        null
                    }
                } else {
                    null
                }
            }
            wallpaperDao.insertAll(wallpapers)
        } catch (e: Exception) {
            // Handle exceptions
        }
    }

    private suspend fun getFileUrl(fileId: String): String = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getFile(fileId)
            "https://api.telegram.org/file/bot<YOUR_TOKEN>/${response.result.filePath}"
        } catch (e: Exception) {
            ""
        }
    }

    private fun extractAnimeName(caption: String): String? {
        val pattern = Pattern.compile("\\[(.*?)\\]")
        val matcher = pattern.matcher(caption)
        return if (matcher.find()) {
            matcher.group(1)
        } else {
            null
        }
    }
}

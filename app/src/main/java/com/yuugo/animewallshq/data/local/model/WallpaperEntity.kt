package com.yuugo.animewallshq.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallpapers")
data class WallpaperEntity(
    @PrimaryKey val messageId: Int,
    val previewUrl: String,
    val fullImageUrl: String,
    val animeName: String
)

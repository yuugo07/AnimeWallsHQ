package com.yuugo.animewallshq.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yuugo.animewallshq.data.local.dao.WallpaperDao
import com.yuugo.animewallshq.data.local.model.WallpaperEntity

@Database(entities = [WallpaperEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wallpaperDao(): WallpaperDao
}

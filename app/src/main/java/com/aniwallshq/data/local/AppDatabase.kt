package com.aniwallshq.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aniwallshq.data.local.dao.WallpaperDao
import com.aniwallshq.data.local.model.WallpaperEntity

@Database(entities = [WallpaperEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wallpaperDao(): WallpaperDao
}

package com.aniwallshq.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aniwallshq.data.local.model.WallpaperEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WallpaperDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(wallpapers: List<WallpaperEntity>)

    @Query("SELECT * FROM wallpapers ORDER BY messageId DESC")
    fun getWallpapers(): Flow<List<WallpaperEntity>>

    @Query("SELECT * FROM wallpapers WHERE animeName LIKE '%' || :query || '%' ORDER BY messageId DESC")
    fun searchByAnimeName(query: String): Flow<List<WallpaperEntity>>

    @Query("DELETE FROM wallpapers")
    suspend fun clearAll()
}

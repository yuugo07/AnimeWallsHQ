package com.aniwallshq.di

import android.content.Context
import androidx.room.Room
import com.aniwallshq.data.local.AppDatabase
import com.aniwallshq.data.local.dao.WallpaperDao
import com.aniwallshq.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // NOTE: The BASE_URL should point to your Cloudflare Worker URL.
    // Using a placeholder for now.
    private const val BASE_URL = "https://animewalls.yuugo.workers.dev/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "animewalls_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideWallpaperDao(appDatabase: AppDatabase): WallpaperDao {
        return appDatabase.wallpaperDao()
    }

    @Provides
    @Singleton
    fun provideDownloader(@ApplicationContext context: Context): com.aniwallshq.util.Downloader {
        return com.aniwallshq.util.AndroidDownloader(context)
    }

    @Provides
    @Singleton
    fun provideWallpaperSetter(@ApplicationContext context: Context): com.aniwallshq.util.WallpaperSetter {
        return com.aniwallshq.util.AndroidWallpaperSetter(context)
    }
}

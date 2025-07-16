package com.yuugo.animewallshq.di

import android.content.Context
import androidx.room.Room
import com.yuugo.animewallshq.BuildConfig
import com.yuugo.animewallshq.data.local.AppDatabase
import com.yuugo.animewallshq.data.local.dao.WallpaperDao
import com.yuugo.animewallshq.data.remote.ApiService
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

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "animewallshq_database"
        ).build()
    }

    @Provides
    fun provideWallpaperDao(appDatabase: AppDatabase): WallpaperDao {
        return appDatabase.wallpaperDao()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.CLOUDFLARE_WORKER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}

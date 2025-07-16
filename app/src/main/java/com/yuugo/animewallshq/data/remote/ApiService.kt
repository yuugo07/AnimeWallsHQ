package com.yuugo.animewallshq.data.remote

import com.yuugo.animewallshq.data.remote.model.TelegramResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("getMessages")
    suspend fun getWallpapers(
        @Query("chat_id") chatId: String,
        @Query("message_id") offset: Int,
        @Query("limit") limit: Int = 20
    ): Response<TelegramResponse>
}

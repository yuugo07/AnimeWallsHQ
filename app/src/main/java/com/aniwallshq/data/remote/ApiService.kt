package com.aniwallshq.data.remote

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    /**
     * Fetches a list of messages (potential wallpapers) from the Telegram channel
     * via the Cloudflare Worker.
     *
     * @param offset The sequential identifier of the first message to be returned.
     * @param limit The maximum number of messages to be returned.
     */
    @GET("getMessages")
    suspend fun getWallpapers(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): JsonObject

    /**
     * Fetches the file path for a given file_id. This path is then used to
     * construct the full download URL.
     *
     * @param fileId The unique identifier for the file.
     */
    @GET("getFile")
    suspend fun getFile(
        @Query("file_id") fileId: String
    ): JsonObject
}

package com.yuugo.animewallshq.data.remote.model

import com.google.gson.annotations.SerializedName

data class TelegramResponse(
    @SerializedName("ok") val ok: Boolean,
    @SerializedName("result") val result: List<Message>
)

data class Message(
    @SerializedName("message_id") val messageId: Int,
    @SerializedName("photo") val photo: List<PhotoSize>?,
    @SerializedName("caption") val caption: String?
)

data class PhotoSize(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("file_size") val fileSize: Int?
)

package com.aniwallshq.data.remote.model

import com.google.gson.annotations.SerializedName

data class TelegramResponse(
    val ok: Boolean,
    val result: List<Message>
)

data class Message(
    @SerializedName("message_id") val messageId: Int,
    val photo: List<PhotoSize>?,
    val caption: String?
)

data class PhotoSize(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    val width: Int,
    val height: Int,
    @SerializedName("file_size") val fileSize: Int?
)

data class FileResponse(
    val ok: Boolean,
    val result: FileResult
)

data class FileResult(
    @SerializedName("file_id") val fileId: String,
    @SerializedName("file_unique_id") val fileUniqueId: String,
    @SerializedName("file_path") val filePath: String,
    @SerializedName("file_size") val fileSize: Int?
)

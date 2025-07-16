package com.aniwallshq.util

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri

interface Downloader {
    fun downloadFile(url: String, fileName: String): Long
}

class AndroidDownloader(
    private val context: Context
) : Downloader {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    override fun downloadFile(url: String, fileName: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("image/jpeg")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle(fileName)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "AnimeWallsHQ/$fileName")
        return downloadManager.enqueue(request)
    }
}

package com.aniwallshq.util

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

interface WallpaperSetter {
    fun setWallpaper(url: String)
}

class AndroidWallpaperSetter(
    private val context: Context
) : WallpaperSetter {

    private val wallpaperManager = WallpaperManager.getInstance(context)

    override fun setWallpaper(url: String) {
        Glide.with(context)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    try {
                        wallpaperManager.setBitmap(resource)
                    } catch (e: Exception) {
                        // Handle exceptions
                    }
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // Do nothing
                }
            })
    }
}

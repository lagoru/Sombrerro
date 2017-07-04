package com.example.lagoru.sombrerro.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import com.example.lagoru.sombrerro.baseApplication


/**
 * Created by lagoru on 13.06.17.
 */

class ScreenUtils {
    var height = -1
    var width = -1
    var logicalDensity = -1F

    init {
        val displayMetrics = DisplayMetrics()
        val windowManager = baseApplication?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        height = displayMetrics.heightPixels
        width = displayMetrics.widthPixels
        logicalDensity = displayMetrics.density
    }

    fun convertFromPixelsToDp(pixels: Int): Int {
        return (pixels / logicalDensity + 0.5f).toInt()
    }

    fun convertFromDpToPixels(dp: Int): Int {
        return (dp * logicalDensity + 0.5f).toInt()
    }
}
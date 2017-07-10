package com.example.lagoru.sombrerro.utils

import com.example.lagoru.sombrerro.R
import com.example.lagoru.sombrerro.baseApplication

/**
 * Created by lagoru on 10.07.17.
 */
object BasicUtils {
    val isMockEnabled: Boolean
        get() = baseApplication!!.resources.getBoolean(R.bool.mocks_enabled)
}
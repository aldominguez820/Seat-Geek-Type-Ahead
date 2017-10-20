package com.example.myapplication.utils

import com.example.myapplication.data.entities.Event

/**
 * Created by user on 10/20/17.
 */
object ImageUtils {
    val PLACEHOLDER_IMAGE = "https://chairnerd.global.ssl.fastly.net/images/sg-Spotlight.png"

    fun getImage(event: Event): String {
        event.performers
                .filter { it.image != null }
                .forEach { return it.image }

        return PLACEHOLDER_IMAGE
    }
}
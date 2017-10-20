package com.example.myapplication.utils

import android.content.Context
import android.content.Intent
import com.example.myapplication.data.entities.Event
import com.example.myapplication.ui.details.DetailsActivity

/**
 * Created by user on 10/19/17.
 */
object ActivityUtils {
    const val EVENT_KEY = "EVENT_KEY"

    fun startActivityRepository(context: Context, event: Event) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra(EVENT_KEY, event)
        context.startActivity(intent)
    }
}
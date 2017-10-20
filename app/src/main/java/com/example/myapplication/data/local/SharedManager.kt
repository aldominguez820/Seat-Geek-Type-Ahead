package com.example.myapplication.data.local

import com.example.myapplication.data.entities.Event
import com.f2prateek.rx.preferences2.Preference
import com.f2prateek.rx.preferences2.RxSharedPreferences

/**
 * Created by user on 10/20/17.
 */

class SharedManager(rxSharedPreferences: RxSharedPreferences) {

    private val FAVORITE_IDS_KEY = "FAVORITE_IDS_KEY"
    private val preferenceIds: Preference<Set<String>>

    init {
        preferenceIds = rxSharedPreferences.getStringSet(FAVORITE_IDS_KEY)
    }

    fun addFavorite(event: Event) {
        val set = mutableSetOf<String>()
        set.addAll(preferenceIds.get())
        set.add(event.id.toString())
        preferenceIds.set(set)
    }

    fun removeFavorite(event: Event) {
        val set = mutableSetOf<String>()
        set.addAll(preferenceIds.get())
        set.remove(event.id.toString())
        preferenceIds.set(set)
    }

    fun isFavorite(event: Event): Boolean {
        val set = preferenceIds.get()
        return set.contains(event.id.toString())
    }

    fun getFavorites(): Set<String> = preferenceIds.get()

}
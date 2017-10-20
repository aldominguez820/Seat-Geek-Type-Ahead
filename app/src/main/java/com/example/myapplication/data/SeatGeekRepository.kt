package com.example.myapplication.data

import com.example.myapplication.BuildConfig
import com.example.myapplication.data.entities.Event
import com.example.myapplication.data.entities.ResultApi
import com.example.myapplication.data.local.SharedManager
import com.example.myapplication.data.remote.RetrofitManager
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by user on 10/19/17.
 */
class SeatGeekRepository(private val seatGeekService: RetrofitManager.SeatGeekService, private val sharedManager: SharedManager) {

    fun retrieveEvents(query: String, observer: Observer<ResultApi>) {
        seatGeekService.getEvents(query, BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    fun removeFavorite(event: Event) {
        sharedManager.removeFavorite(event)
    }

    fun saveFavorite(event: Event) {
        sharedManager.addFavorite(event)
    }

    fun isFavorite(event: Event) = sharedManager.isFavorite(event)

    fun getFavorites(): Set<String> = sharedManager.getFavorites()

}
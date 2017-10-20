package com.example.myapplication.data.remote

import com.example.myapplication.data.entities.ResultApi
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by user on 10/19/17.
 */
object RetrofitManager {

    interface SeatGeekService {
        @GET("/2/events")
        fun getEvents(@Query("q") user: String, @Query("client_id") clientId: String): Observable<ResultApi>
    }
}
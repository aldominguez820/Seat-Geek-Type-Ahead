package com.example.myapplication.di

import com.example.myapplication.data.SeatGeekRepository
import com.example.myapplication.data.local.SharedManager
import com.example.myapplication.data.remote.RetrofitManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by user on 10/19/17.
 */
@Singleton
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideSeatGeekRepository(seatGeekService: RetrofitManager.SeatGeekService, sharedManager: SharedManager)
            = SeatGeekRepository(seatGeekService, sharedManager)
}
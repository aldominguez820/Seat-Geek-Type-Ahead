package com.example.myapplication.di

import com.example.myapplication.data.SeatGeekRepository
import dagger.Component
import javax.inject.Singleton

/**
 * Created by user on 10/19/17.
 */
@Singleton
@Component(modules = arrayOf(NetworkModule::class, RepositoryModule::class, SharedModule::class))
interface ApplicationComponent {
    fun seatGeekRepository(): SeatGeekRepository
}
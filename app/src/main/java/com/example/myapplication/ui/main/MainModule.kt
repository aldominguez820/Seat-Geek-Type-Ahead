package com.example.myapplication.ui.main

import com.example.myapplication.data.SeatGeekRepository
import com.example.myapplication.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by user on 10/19/17.
 */

@Module
internal class MainModule {

    @ActivityScope
    @Provides
    fun provideMainPresenter(seatGeekRepository: SeatGeekRepository) =
            MainPresenter(seatGeekRepository)
}

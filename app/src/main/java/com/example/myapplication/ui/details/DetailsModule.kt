package com.example.myapplication.ui.details

import com.example.myapplication.data.SeatGeekRepository
import com.example.myapplication.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by user on 10/19/17.
 */
@Module
class DetailsModule {

    @ActivityScope
    @Provides
    fun provideDetailsPresenter(seatGeekRepository: SeatGeekRepository): DetailsPresenter
            = DetailsPresenter(seatGeekRepository)
}
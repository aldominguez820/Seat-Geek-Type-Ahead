package com.example.myapplication.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.myapplication.data.local.SharedManager
import com.f2prateek.rx.preferences2.RxSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by user on 10/20/17.
 */

@Singleton
@Module
class SharedModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideSharedPreferences(): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    @Singleton
    @Provides
    fun provideRxSharedPreferences(sharedPreferences: SharedPreferences): RxSharedPreferences =
            RxSharedPreferences.create(sharedPreferences)

    @Singleton
    @Provides
    fun provideSharedManager(rxSharedPreferences: RxSharedPreferences): SharedManager =
            SharedManager(rxSharedPreferences)
}
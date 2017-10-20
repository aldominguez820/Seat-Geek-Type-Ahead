package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.*
import com.facebook.stetho.Stetho

/**
 * Created by user on 10/19/17.
 */

class App : Application() {
    var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this);

        applicationComponent = DaggerApplicationComponent.builder()
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .sharedModule(SharedModule(applicationContext))
                .build()
    }
}

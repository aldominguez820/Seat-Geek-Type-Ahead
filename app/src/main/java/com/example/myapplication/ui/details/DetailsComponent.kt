package com.example.myapplication.ui.details

import com.example.myapplication.di.ApplicationComponent
import com.example.myapplication.di.scopes.ActivityScope
import dagger.Component

/**
 * Created by user on 10/19/17.
 */

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(DetailsModule::class))
internal interface DetailsComponent {
    fun inject(detailsActivity: DetailsActivity)
}
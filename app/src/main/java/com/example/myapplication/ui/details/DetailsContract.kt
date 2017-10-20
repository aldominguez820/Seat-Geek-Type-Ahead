package com.example.myapplication.ui.details

import com.example.myapplication.base.BasePresenter
import com.example.myapplication.base.BaseView
import com.example.myapplication.data.entities.Event

/**
 * Created by user on 10/19/17.
 */
interface DetailsContract {
    interface View : BaseView {
        fun setFavorite(favorite: Boolean)
    }

    interface Presenter : BasePresenter<View> {
        fun toggleFavorite(event: Event)
        fun checkFavorite(event: Event)
    }
}
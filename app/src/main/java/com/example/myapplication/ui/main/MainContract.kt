package com.example.myapplication.ui.main

import com.example.myapplication.base.BasePresenter
import com.example.myapplication.base.BaseView
import com.example.myapplication.data.entities.Event

/**
 * Created by user on 10/19/17.
 */
interface MainContract {
    interface View : BaseView {
        fun showResults(results: List<Event>)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter : BasePresenter<View> {
        fun loadResults(searchTerm: String)
    }
}
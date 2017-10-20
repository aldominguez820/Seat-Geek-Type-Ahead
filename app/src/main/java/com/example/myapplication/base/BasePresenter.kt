package com.example.myapplication.base

/**
 * Created by user on 10/19/17.
 */
interface BasePresenter<in T : BaseView> {
    fun attachView(view: T)
    fun detachView()
}
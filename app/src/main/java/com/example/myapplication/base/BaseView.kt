package com.example.myapplication.base

/**
 * Created by user on 10/19/17.
 */
interface BaseView {
    fun showError(error: String)
    fun injectDependencies()
}
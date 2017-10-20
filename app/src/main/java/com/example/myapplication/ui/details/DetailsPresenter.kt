package com.example.myapplication.ui.details

import com.example.myapplication.data.SeatGeekRepository
import com.example.myapplication.data.entities.Event


/**
 * Created by user on 10/19/17.
 */
class DetailsPresenter(private val seatGeekRepository: SeatGeekRepository) : DetailsContract.Presenter {

    private var view: DetailsContract.View? = null

    override fun attachView(view: DetailsContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun toggleFavorite(event: Event) {
        if (seatGeekRepository.isFavorite(event)) {
            seatGeekRepository.removeFavorite(event)
            view?.setFavorite(false)
        } else {
            seatGeekRepository.saveFavorite(event)
            view?.setFavorite(true)
        }
    }

    override fun checkFavorite(event: Event) {
        view?.setFavorite(seatGeekRepository.isFavorite(event))
    }
}
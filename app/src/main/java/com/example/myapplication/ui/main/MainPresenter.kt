package com.example.myapplication.ui.main

import android.support.annotation.VisibleForTesting
import com.example.myapplication.data.SeatGeekRepository
import com.example.myapplication.data.entities.Event
import com.example.myapplication.data.entities.ResultApi
import com.example.myapplication.utils.ExtensionUtils.void
import com.example.myapplication.utils.ExtensionUtils.voidBoolean
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by user on 10/19/17.
 */

class MainPresenter(private val seatGeekRepository: SeatGeekRepository) : MainContract.Presenter {

    private var view: MainContract.View? = null

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: MainContract.View) {
        this.view = view
    }

    override fun detachView() {
        compositeDisposable.dispose()
        this.view = null
    }

    override fun loadResults(searchTerm: String) {
        view?.showProgress()
        seatGeekRepository.retrieveEvents(searchTerm,
                object : Observer<ResultApi> {
                    override fun onComplete() = view?.hideProgress().void()
                    override fun onNext(t: ResultApi) = view?.showResults(mergeFavorites(t.events)).void()
                    override fun onError(e: Throwable) = view?.showError(e.toString()).void()
                    override fun onSubscribe(d: Disposable) = compositeDisposable.add(d).voidBoolean()
                }
        )
    }

    @VisibleForTesting
    fun mergeFavorites(events: List<Event>): List<Event> {
        val favorites = seatGeekRepository.getFavorites()
        events.forEach { it.isOpen = it.id.toString() in favorites }
        return events
    }
}

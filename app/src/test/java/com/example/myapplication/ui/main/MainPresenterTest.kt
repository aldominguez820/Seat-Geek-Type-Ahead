package com.example.myapplication.ui.main

import com.example.myapplication.data.SeatGeekRepository
import com.example.myapplication.data.entities.Event
import com.example.myapplication.data.entities.ResultApi
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observer
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

/**
 * Created by user on 10/20/17.
 */

class MainPresenterTest {
    private val mockEventId = 12
    private val searchTerm = "Texas Ranger"

    private val view = mock<MainContract.View> {}
    private val event = mock<Event> {
        on { id }.thenReturn(mockEventId)
    }
    private val seatGeekRepository = mock<SeatGeekRepository> {
        on { isFavorite(event) }.thenReturn(true)
    }

    lateinit var mainPresenter: MainPresenter

    @Before
    fun setUp() {
        mainPresenter = MainPresenter(seatGeekRepository)
    }

    @Test
    fun whenPresenterCreate_shouldInstantiateClass() {
        assertNotNull(mainPresenter)
    }

    @Test
    fun whenViewAdded_shouldBeAbleToRemove() {
        mainPresenter.attachView(view)
        mainPresenter.detachView()
    }

    @Test
    fun whenTextTypedOnView_shouldStartLookingUpApi() {
        mainPresenter.attachView(view)
        mainPresenter.loadResults(searchTerm)

        verify(view).showProgress()
        verify(seatGeekRepository).retrieveEvents(eq(searchTerm), any<Observer<ResultApi>>());
    }

    @Test
    fun whenCreatingEventList_shouldCheckFavorites() {
        mainPresenter.mergeFavorites(listOf(event))

        verify(seatGeekRepository).getFavorites()
    }
}
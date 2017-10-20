package com.example.myapplication.ui.details

import com.example.myapplication.data.SeatGeekRepository
import com.example.myapplication.data.entities.Event
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

/**
 * Created by user on 10/20/17.
 */
class DetailsPresenterTest {
    private val mockEventId = 12
    private val searchTerm = "Texas Ranger"

    private val view = mock<DetailsContract.View> {}
    private val event = mock<Event> {
        on { id }.thenReturn(mockEventId)
    }
    private val seatGeekRepository = mock<SeatGeekRepository> {
        on { isFavorite(event) }.thenReturn(true)
    }

    lateinit var detailsPresenter: DetailsPresenter

    @Before
    fun setUp() {
        detailsPresenter = DetailsPresenter(seatGeekRepository)
    }

    @Test
    fun whenViewAttached_shouldCheckFavorite() {
        detailsPresenter.attachView(view)
        detailsPresenter.checkFavorite(event)

        verify(seatGeekRepository).isFavorite(event)
        verify(view).setFavorite(true)
    }

    @Test
    fun whenFavoriteClicked_shouldToggleRepository() {
        detailsPresenter.attachView(view)
        detailsPresenter.toggleFavorite(event)

        verify(seatGeekRepository).isFavorite(event)
        verify(seatGeekRepository).removeFavorite(event)
    }
}
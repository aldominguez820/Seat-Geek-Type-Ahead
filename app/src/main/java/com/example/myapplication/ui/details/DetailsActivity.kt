package com.example.myapplication.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.data.entities.Event
import com.example.myapplication.di.ApplicationComponent
import com.example.myapplication.utils.ActivityUtils
import com.example.myapplication.utils.ImageUtils
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject
import android.view.MenuItem
import android.view.View


class DetailsActivity : AppCompatActivity(), DetailsContract.View {

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    private lateinit var event: Event
    private var menuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        injectDependencies()
        initViews()

        detailsPresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        detailsPresenter.detachView()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun injectDependencies() {
        val applicationComponent: ApplicationComponent? = (application as App).applicationComponent
        DaggerDetailsComponent.builder()
                .applicationComponent(applicationComponent)
                .detailsModule(DetailsModule())
                .build()
                .inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.details_menu, menu)
        menuItem = menu?.findItem(R.id.m_details_favorite)
        detailsPresenter.checkFavorite(event)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.m_details_favorite -> {
            detailsPresenter.toggleFavorite(event)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun setFavorite(favorite: Boolean) {
        if (favorite) {
            menuItem?.setIcon(R.drawable.ic_favorite_white_24dp)
            a_details_favorite.visibility = View.VISIBLE
        } else {
            menuItem?.setIcon(R.drawable.ic_favorite_border_white_24dp)
            a_details_favorite.visibility = View.INVISIBLE
        }
    }

    private fun initViews() {
        event = intent.getParcelableExtra<Event>(ActivityUtils.EVENT_KEY)

        supportActionBar?.subtitle = event.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val image = ImageUtils.getImage(event)
        Glide.with(this).load(image).into(a_details_img)

        a_details_title.text = event.title
        a_details_subtitle.text = event.venue.name
        a_details_city.text = event.venue.city
        a_details_date.text = event.datetimeLocal
    }
}

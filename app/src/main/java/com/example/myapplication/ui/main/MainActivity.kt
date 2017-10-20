package com.example.myapplication.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.data.entities.Event
import com.example.myapplication.utils.ActivityUtils
import com.example.myapplication.utils.SpacesItemDecoration
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainContract.View {

    private val TAG = "MainActivityTAG_"

    @Inject
    lateinit var mainPresenter: MainPresenter

    private val events: MutableList<Event> = mutableListOf<Event>()
    private var mainAdapter: MainAdapter? = null
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDependencies()
        initViews()

        mainPresenter.attachView(this)
        hideKeyboard();
    }

    override fun onResume() {
        super.onResume()
        setTypeAhead()
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()

        mainPresenter.detachView()
    }

    override fun injectDependencies() {
        val applicationComponent = (application as App).applicationComponent

        DaggerMainComponent.builder()
                .applicationComponent(applicationComponent)
                .mainModule(MainModule())
                .build()
                .inject(this)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showResults(results: List<Event>) {
        println(results)
        events.clear()
        events.addAll(results)
        mainAdapter?.notifyDataSetChanged()
    }

    override fun showProgress() {
        a_main_progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        a_main_progress.visibility = View.INVISIBLE
    }

    private fun hideKeyboard() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private fun setTypeAhead() {
        val editTextSub = RxTextView.textChanges(a_main_et)
                .debounce(100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ mainPresenter.loadResults(it.toString()) })
        compositeDisposable.add(editTextSub)
    }

    private fun initViews() {
        mainAdapter = MainAdapter(events) { ActivityUtils.startActivityRepository(this, it) }
        a_main_recycler.adapter = mainAdapter
        a_main_recycler.layoutManager = LinearLayoutManager(this)
        a_main_recycler.addItemDecoration(SpacesItemDecoration(8))
    }
}

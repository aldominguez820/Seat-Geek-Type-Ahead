package com.example.myapplication.ui.main

import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.entities.Event
import com.example.myapplication.utils.ImageUtils
import kotlinx.android.synthetic.main.recycler_row.view.*

/**
 * Created by user on 10/19/17.
 */
class MainAdapter(private val eventList: List<Event>, private val listener: (Event) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(eventList[position], listener)

    override fun getItemCount(): Int = eventList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent?.context)
        val view: View = layoutInflater.inflate(R.layout.recycler_row, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(event: Event, listener: (Event) -> Unit) = with(itemView) {
            val image = ImageUtils.getImage(event)
            Glide.with(context).load(image).into(r_row_img)

            r_row_title.text = event.title
            r_row_favorite.visibility = if (event.isOpen) View.VISIBLE else View.GONE
            r_row_city.text = event.venue.city
            r_row_date.text = event.datetimeLocal

            setOnClickListener { listener(event) }
        }
    }
}
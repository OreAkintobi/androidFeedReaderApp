package com.ore.top10downloader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class FeedAdapter(
    context: Context,
    private val resource: Int,
    private val items: List<FeedEntry>
) : ArrayAdapter<FeedAdapter>(context, resource) {
    private val inflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return items.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val currentItem = items[position]

        viewHolder.tvTitle.text = currentItem.title
        viewHolder.tvPublishDate.text = currentItem.publishDate
        viewHolder.tvSource.text = currentItem.source

        return view
    }
}
package com.ore.top10downloader

import android.view.View
import android.widget.TextView

class ViewHolder(v: View) {
    val tvTitle: TextView = v.findViewById(R.id.tvTitle)
    val tvPublishDate: TextView = v.findViewById(R.id.tvPublishDate)
    val tvSource: TextView = v.findViewById(R.id.tvSource)
}


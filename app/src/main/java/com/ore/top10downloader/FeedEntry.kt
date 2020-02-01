package com.ore.top10downloader

class FeedEntry {
    var title: String = ""
    var link: String = ""
    var publishDate: String = ""

    var source: String = ""

    override fun toString(): String {
        return """
            title = $title
            link = $link
            publishDate = $publishDate
            source = $source
        """.trimIndent()
    }
}


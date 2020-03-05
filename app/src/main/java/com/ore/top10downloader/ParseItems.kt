package com.ore.top10downloader

import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.util.*
import kotlin.collections.ArrayList

class ParseItems {
    private val TAG = "ParseItems"
    val items = ArrayList<FeedEntry>()

    fun parse(xmlData: String): Boolean {
        Log.d(TAG, "parse called with $xmlData")
        var status = true
        var inItem = false
        var textValue = ""

        try {
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true
            val xpp = factory.newPullParser()
            xpp.setInput(xmlData.reader())
            var eventType = xpp.eventType
            var currentRecord = FeedEntry()
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName =
                    xpp.name?.toLowerCase(Locale.ROOT)
                when (eventType) {
                    XmlPullParser.START_TAG -> {
//                        Log.d(TAG, "parse: Starting tag for $tagName")
                        if (tagName == "item") {
                            inItem = true
                        }
                    }

                    XmlPullParser.TEXT -> textValue = xpp.text

                    XmlPullParser.END_TAG -> {
//                        Log.d(TAG, "parse: Ending tag for $tagName")
                        if (inItem) {
                            when (tagName) {
                                "item" -> {
                                    items.add(currentRecord)
                                    inItem = false
                                    currentRecord = FeedEntry()   // create a new object
                                }
                                "title" -> currentRecord.title = textValue
                                "link" -> currentRecord.link = textValue
                                "pubdate" -> currentRecord.publishDate = textValue
                                "source" -> currentRecord.source = textValue
                            }
                        }
                    }
                }
                // Nothing else to do
                eventType = xpp.next()
            }

//            for (item in items) {
//                Log.d(TAG, "****************")
//                Log.d(TAG, item.toString())
//            }
        } catch (e: Exception) {
            e.printStackTrace()
            status = false
        }
        return status
    }
}
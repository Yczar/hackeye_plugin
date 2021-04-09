package com.czarfy.hackeye_plugin_example

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import android.widget.RemoteViews
import com.czarfy.hackeye_plugin.WidgetLaunchIntent
import com.czarfy.hackeye_plugin.WidgetProvider

class CustomWidgetProvider : WidgetProvider() {


    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray, widgetData: SharedPreferences) {
        appWidgetIds.forEach { widgetId ->
            val views = RemoteViews(context.packageName, R.layout.widget_layout).apply {
                // Open App on Widget Click
//                val pendingIntent = WidgetLaunchIntent.getActivity(
//                        context,
//                        MainActivity::class.java)
//                setOnClickPendingIntent(R.id.help_widget, pendingIntent)

                // Swap Title Text by calling Dart Code in the Background
//                setTextViewText(R.id.widget_title, widgetData.getString("title", null)
//                        ?: "No Title Set")
//                val backgroundIntent = HomeWidgetBackgroundIntent.getBroadcast(
//                        context,
//                        Uri.parse("homeWidgetExample://titleClicked")
//                )
//                setOnClickPendingIntent(R.id.widget_title, backgroundIntent)

                val message = widgetData.getString("message", null)
//                setTextViewText(R.id.widget_message, message
//                        ?: "No Message Set")
                // Detect App opened via Click inside Flutter
                val pendingIntentWithData = WidgetLaunchIntent.getActivity(
                        context,
                        MainActivity::class.java,
                        Uri.parse("homeWidgetExample://message?message=$message"))
                setOnClickPendingIntent(R.id.help_widget, pendingIntentWithData)
            }

            appWidgetManager.updateAppWidget(widgetId, views)
        }
    }

}
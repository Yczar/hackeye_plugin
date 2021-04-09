package com.czarfy.hackeye_plugin

import android.app.Activity
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri

object WidgetLaunchIntent {

    const val WIDGET_LAUNCH_ACTION = "com.hackeye.widgetwidget.action.LAUNCH"

    fun <T> getActivity(context: Context, activityClass: Class<T>, uri: Uri? = null): PendingIntent where T : Activity {
        val intent = Intent(context, activityClass)
        intent.data = uri
        intent.action = WIDGET_LAUNCH_ACTION

        return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }
}


object WidgetBackgroundIntent {
    private const val WIDGET_BACKGROUND_ACTION = "com.hackeye.widget.action.BACKGROUND"

    fun getBroadcast(context: Context, uri: Uri? = null): PendingIntent {
        val intent = Intent(context, WidgetBackgroundReceiver::class.java)
        intent.data = uri
        intent.action = WIDGET_BACKGROUND_ACTION

        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }
}
package com.czarfy.hackeye_plugin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.flutter.FlutterInjector

class WidgetBackgroundReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val flutterLoader = FlutterInjector.instance().flutterLoader()
        flutterLoader.startInitialization(context)
        flutterLoader.ensureInitializationComplete(context, null)
        WidgetBackgroundService.enqueueWork(context, intent)
    }
}
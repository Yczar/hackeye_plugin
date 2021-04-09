import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

/// Dispatcher used for calling dart code from Native Code while in the background
void callbackDispatcher() {
  const _backgroundChannel = MethodChannel('haeye_widget/background');
  WidgetsFlutterBinding.ensureInitialized();

  _backgroundChannel.setMethodCallHandler((call) async {
    final args = call.arguments;

    final callback = PluginUtilities.getCallbackFromHandle(
      CallbackHandle.fromRawHandle(args[0]),
    );

    final rawUri = args[1] as String;

    final uri = Uri.parse(rawUri);

    callback?.call(uri);
  });

  _backgroundChannel.invokeMethod('HaeyeWidget.backgroundInitialized');
}

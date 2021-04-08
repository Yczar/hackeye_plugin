import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:hackeye_plugin/hackeye_plugin.dart';

void main() {
  const MethodChannel channel = MethodChannel('hackeye_plugin');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await HackeyePlugin.platformVersion, '42');
  });
}

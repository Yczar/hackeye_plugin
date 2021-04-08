#import "HackeyePlugin.h"
#if __has_include(<hackeye_plugin/hackeye_plugin-Swift.h>)
#import <hackeye_plugin/hackeye_plugin-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "hackeye_plugin-Swift.h"
#endif

@implementation HackeyePlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftHackeyePlugin registerWithRegistrar:registrar];
}
@end

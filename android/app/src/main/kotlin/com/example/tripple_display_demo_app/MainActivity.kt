package com.example.tripple_display_demo_app

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import com.github.waqasshafi001.flutter_multi_display.FlutterMultiDisplayPlugin

class MainActivity : FlutterActivity() {
    private var multiDisplayPlugin: FlutterMultiDisplayPlugin? = null

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        // Store reference to FlutterMultiDisplayPlugin
        multiDisplayPlugin = flutterEngine.plugins.get(
            FlutterMultiDisplayPlugin::class.java
        ) as? FlutterMultiDisplayPlugin
    }

    override fun onStart() {
        super.onStart()
        // Resume secondary engines when app starts
        multiDisplayPlugin?.onStart()
    }

    override fun onStop() {
        super.onStop()
        // Pause secondary engines when app stops
        multiDisplayPlugin?.onStop()
    }

    override fun cleanUpFlutterEngine(flutterEngine: FlutterEngine) {
        super.cleanUpFlutterEngine(flutterEngine)
        // Clear the plugin reference
        multiDisplayPlugin = null
    }
}
package crash.log.android

import android.app.Application
import crash.reporter.lib.CrashReporter

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) CrashReporter.initialize(applicationContext)

    }
}
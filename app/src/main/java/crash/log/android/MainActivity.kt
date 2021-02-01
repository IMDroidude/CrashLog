package crash.log.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import crash.reporter.lib.CrashReporter
import crash.reporter.lib.ui.CrashReporterActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nullPointer.setOnClickListener {
            context.resources
        }
        indexOutOfBound.setOnClickListener {
            val list: ArrayList<String> = ArrayList<String>()
            list.add("test")
            val crashMe = list[2]
        }
        classCastExeption.setOnClickListener {
            val x: Any = 0
            println(x as String)
        }

        arrayStoreException.setOnClickListener {

        }
        Thread(Runnable {
            try {
                context.resources
            } catch (e: Exception) {
                //log caught Exception
                CrashReporter.logException(e)
            }
        }).start()

        crashLogActivity.setOnClickListener {
            val intent = Intent(this@MainActivity, CrashReporterActivity::class.java)
            startActivity(intent)
        }
    }
}
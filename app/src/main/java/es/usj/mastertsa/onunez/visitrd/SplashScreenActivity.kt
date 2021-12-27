package es.usj.mastertsa.onunez.visitrd

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import java.util.*

class SplashScreenActivity : AppCompatActivity() {
    companion object { private val SPLASH_SCREEN_DELAY: Long = 4000 }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        setContentView(R.layout.activity_splash_screen)
        val task = object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashScreenActivity,
                    MainActivity::class.java
                )
                startActivity(intent)
                finish()
            }
        }
        val timer = Timer()
        timer.schedule(task, SPLASH_SCREEN_DELAY)
    }
}
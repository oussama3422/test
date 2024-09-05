package com.example.myapplication
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_UP -> {
                openGoogleMaps()
                return true
            }
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                openYouTube()
                return true
            }
            KeyEvent.KEYCODE_BACK -> {
                openInstagram()
                return true
            }
            else -> return super.onKeyDown(keyCode, event)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMaps = findViewById<Button>(R.id.buttonMaps)
        val buttonYouTube = findViewById<Button>(R.id.buttonYouTube)
        val buttonInstagram = findViewById<Button>(R.id.buttonInstagram)

        buttonMaps.setOnClickListener {
            openGoogleMaps()
        }

        buttonYouTube.setOnClickListener {
            openYouTube()
        }

        buttonInstagram.setOnClickListener {
            openInstagram()
        }
    }

    private fun openGoogleMaps() {
        val gmmIntentUri = Uri.parse("geo:0,0?q=restaurants")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }
    }

    private fun openYouTube() {
        val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"))
        if (youtubeIntent.resolveActivity(packageManager) != null) {
            startActivity(youtubeIntent)
        }
    }

    private fun openInstagram() {
        val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"))
        if (instagramIntent.resolveActivity(packageManager) != null) {
            startActivity(instagramIntent)
        }
    }
}

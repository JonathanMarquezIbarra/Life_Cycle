package com.example.lifecycle

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var mediaPlayer:MediaPlayer? = null
    private var position:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.rush_e)


        Log.i("Life cycle","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Life cycle","onStart")
        mediaPlayer?.start()
    }

    override fun onResume() {
        super.onResume()
        Log.i("Life cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Life cycle","onPause")
        mediaPlayer?.pause()
    }

    override fun onStop() {
        super.onStop()
        Log.i("Life cycle","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Life cycle","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Life cycle","onDestroy")
    }
}
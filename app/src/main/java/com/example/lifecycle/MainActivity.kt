package com.example.lifecycle

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var mediaPlayer:MediaPlayer? = null
    private var position:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Life cycle","onCreate")

        findViewById<MaterialButton>(R.id.btnCheck).setOnClickListener {
            startActivity(Intent(this,DialogActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Life cycle","onStart")
        mediaPlayer = MediaPlayer.create(this, R.raw.rush_e)
    }

    override fun onResume() {
        super.onResume()
        Log.i("Life cycle","onResume")
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        Log.i("Life cycle","onPause")
        mediaPlayer?.pause()
        if (mediaPlayer != null){
            position = mediaPlayer!!.currentPosition
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("Life cycle","onStop")
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
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
package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.mathgame.databinding.ActivityMainBinding

class SpleshScanner : AppCompatActivity() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splesh_scanner)
        textView = findViewById(R.id.tv_anim)
        Handler().postDelayed(Runnable() {
            val splash = Intent(this, MainActivity::class.java)
            startActivity(splash)
            finish()
        }, 5000)

        val anim = AnimationUtils.loadAnimation(this, R.anim.anim1)
        textView.startAnimation(anim)

    }
}
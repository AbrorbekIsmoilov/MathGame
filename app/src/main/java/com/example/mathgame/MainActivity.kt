package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.mathQuiz.setOnClickListener {
            val splash = Intent(this,Math_Quiz::class.java)
            startActivity(splash)
        }
        binding.mathTest.setOnClickListener {
            val test = Intent(this,Math_Test::class.java)
            startActivity(test)
        }
        binding.exit.setOnClickListener {
            finish()
        }

    }
}
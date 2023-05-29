package com.example.mathgame

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.util.*

class Math_Quiz : AppCompatActivity() {
    private lateinit var tv_text : TextView
    private lateinit var rb1 : RadioButton
    private lateinit var rb2 : RadioButton
    private lateinit var rb3 : RadioButton
    private lateinit var rb4 : RadioButton
    private lateinit var btn_next : Button
    private lateinit var tv_javob : TextView
    private lateinit var rbg: RadioGroup
    private lateinit var exit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_quiz)

        tv_text = findViewById(R.id.tv_text)
        exit = findViewById(R.id.btn_exit)
        tv_javob = findViewById(R.id.tv_javob)
        btn_next = findViewById(R.id.btn_next)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rb3 = findViewById(R.id.rb3)
        rb4 = findViewById(R.id.rb4)
        rbg = findViewById(R.id.rbg)
        randomQuiz()
        exit.setOnClickListener {
            val test = Intent(this,MainActivity::class.java)
            startActivity(test)
            finish()
        }

        btn_next.setOnClickListener {
            if (rb1.isChecked){
                if (rb1.text.toString().toInt() == answer){
                    val mediaPlayer = MediaPlayer.create(this, R.raw.right)
                    mediaPlayer.start()
                    tv_javob.text = "T o ' g ' r i"
                }
                else {
                    val mediaPlayer = MediaPlayer.create(this, R.raw.error)
                    mediaPlayer.start()
                    tv_javob.text = "N o t o ' g ' r i"
                }
                rbg.clearCheck()
                randomQuiz()
            }
            if (rb2.isChecked){
                if (rb2.text.toString().toInt() == answer){
                    val mediaPlayer = MediaPlayer.create(this, R.raw.right)
                    mediaPlayer.start()
                    tv_javob.text = "T o ' g ' r i"
                }
                else {
                    val mediaPlayer = MediaPlayer.create(this, R.raw.error)
                    mediaPlayer.start()
                    tv_javob.text = "N o t o ' g ' r i"
                }
                rbg.clearCheck()
                randomQuiz()
            }
            if (rb3.isChecked){
                if (rb3.text.toString().toInt() == answer){
                    val mediaPlayer = MediaPlayer.create(this, R.raw.right)
                    mediaPlayer.start()
                    tv_javob.text = "T o ' g ' r i"
                }
                else {
                    val mediaPlayer = MediaPlayer.create(this, R.raw.error)
                    mediaPlayer.start()
                    tv_javob.text = "N o t o ' g ' r i"
                }
                rbg.clearCheck()
                randomQuiz()
            }
            if (rb4.isChecked){
                if (rb4.text.toString().toInt() == answer){
                    val mediaPlayer = MediaPlayer.create(this, R.raw.right)
                    mediaPlayer.start()
                    tv_javob.text = "T o ' g ' r i"
                }
                else {
                    val mediaPlayer = MediaPlayer.create(this, R.raw.error)
                    mediaPlayer.start()
                    tv_javob.text = "N o t o ' g ' r i"
                }
                rbg.clearCheck()
                randomQuiz()
            }

        }
    }
    var num1 = 0
    var num2 = 0
    var answer = 0
    var quiz = 0
    fun randomQuiz() {
        num1 = Random().nextInt(20)
        num2 = Random().nextInt(20)
        quiz = Random().nextInt(4)

        when (quiz) {
            0 -> {
                tv_text.text = "$num1 + $num2"
                answer = num1 + num2
            }
            1 -> {
                tv_text.text = "$num1 - $num2"
                answer = num1 - num2
            }
            2 -> {
                tv_text.text = "$num1 × $num2"
                answer = num1 * num2
            }
            3 -> {

                try {
                    if (num1%num2!=0) throw Exception()
                    tv_text.text = "$num1 ÷ $num2"
                    answer = num1 / num2
                } catch (e: Exception) {
                    randomQuiz()
                    2
                }
            }
        }
        ekranga()
    }
    var random1 =0
    var random2 =0
    var random3 =0
    fun  randomSonAniqla(){
        random1 = Random().nextInt(200)
        random2 = Random().nextInt(200)
        random3 = Random().nextInt(200)
        if (random1 == random2 || random2 == random3 || random1 == random3){
            randomSonAniqla()
        }
    }
    var tj = 0
    fun ekranga(){
        randomSonAniqla()
        tj = Random().nextInt(4)

        when(tj){
            0->{
                rb1.text = answer.toString()
                rb2.text = random1.toString()
                rb3.text = random2.toString()
                rb4.text = random3.toString()
            }
            1->{
                rb2.text = answer.toString()
                rb1.text = random1.toString()
                rb3.text = random2.toString()
                rb4.text = random3.toString()
            }
            2->{
                rb3.text = answer.toString()
                rb2.text = random1.toString()
                rb1.text = random2.toString()
                rb4.text = random3.toString()
            }
            3->{
                rb4.text = answer.toString()
                rb2.text = random1.toString()
                rb3.text = random2.toString()
                rb1.text = random3.toString()
            }
        }
    }
}
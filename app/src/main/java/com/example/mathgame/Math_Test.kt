package com.example.mathgame

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import java.util.*

class Math_Test : AppCompatActivity() {
    private lateinit var edtAnswer: EditText
    private lateinit var tvQuiz : TextView
    private lateinit var answerText : TextView
    private lateinit var quizText : TextView
    private lateinit var exit : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_test)
        edtAnswer = findViewById(R.id.tv_answer)
        exit = findViewById(R.id.btn_exit)
        tvQuiz = findViewById(R.id.tv_quiz)
        answerText = findViewById(R.id.answer_text)
        quizText=findViewById(R.id.quiz_text)
        exit.setOnClickListener {
            val test = Intent(this,MainActivity::class.java)
            startActivity(test)
            finish()
        }

        randomQuiz()

        edtAnswer.addTextChangedListener {
            if (answer.toString().length == edtAnswer.text.toString().length){
                checking()

            }
        }

    }



    var num1 = 0
    var num2 = 0
    var answer = 0
    var quiz = 0

    fun randomQuiz() {
        num1 = Random().nextInt(10)
        num2 = Random().nextInt(10)
        quiz = Random().nextInt(4)

        when (quiz) {
            0 -> {
                tvQuiz.text = "$num1 + $num2"
                answer = num1 + num2
            }
            1 -> {
                if (num1<num2){
                    randomQuiz()
                    return
                }
                tvQuiz.text = "$num1 - $num2"
                answer = num1 - num2
            }
            2 -> {
                if (num2==0){
                    randomQuiz()
                    return
                }
                tvQuiz.text = "$num1 × $num2"
                answer = num1 * num2
            }
            3 -> {
                if (num1%num2!=0){
                    randomQuiz()
                    return
                }
                try {

                    tvQuiz.text = "$num1 ÷ $num2"
                    answer = num1 / num2
                }catch (e:java.lang.ArithmeticException){
                    randomQuiz()
                    return
                }
            }
        }

    }
    fun checking(){
        if (answer == edtAnswer.text.toString().toInt()){
            val mediaPlayer = MediaPlayer.create(this,R.raw.right)
            mediaPlayer.start()
            quizText.text = "To'g'ri"
        }else{
            quizText.text = "Noto'g'ri"
            val mediaPlayer = MediaPlayer.create(this,R.raw.error)
            mediaPlayer.start()
        }
        edtAnswer.text.clear()
        randomQuiz()
    }
}
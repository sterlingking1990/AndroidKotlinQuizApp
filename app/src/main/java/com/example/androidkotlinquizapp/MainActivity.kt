package com.example.androidkotlinquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import kotlinx.android.synthetic.main.frame_layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var questionOneInflatedInstance=QuizOneFragment()

        var questionTwoInflatedInstance = QuizTwoFragment()


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flQuiz,questionOneInflatedInstance)
        }

        btnQuizOne.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flQuiz,questionOneInflatedInstance)
            }
        }

        btnQuizTwo.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flQuiz,questionTwoInflatedInstance)
            }
        }

    }
}
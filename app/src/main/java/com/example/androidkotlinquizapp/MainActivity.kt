package com.example.androidkotlinquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var questionOneInflatedInstance=QuizOneFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flQuiz,questionOneInflatedInstance)
        }

    }
}
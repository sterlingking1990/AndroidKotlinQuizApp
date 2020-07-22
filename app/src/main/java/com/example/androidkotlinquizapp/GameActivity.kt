package com.example.androidkotlinquizapp

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_recycler.*
import java.util.*
import kotlinx.coroutines.*
import kotlin.concurrent.schedule


class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_recycler)
        var alphaList = mutableListOf<String>()
        for (i in 'A'..'Y') {
            alphaList.add(i.toString())
        }
        for (i in 1..alphaList.size) {
            val button = findViewById<Button>(
                resources.getIdentifier(
                    "btn_$i", "id",
                    this.packageName
                )
            )
            button.text = ""

        }


        btnPlay.setOnClickListener {
            var word_list = arrayOf(1, 4, 7)
            var alphaList = mutableListOf<String>()
            for (i in 'A'..'Y') {
                alphaList.add(i.toString())
            }
            var newAlpha = alphaList.shuffled()

            var j = 0
            while (j < word_list.size) {


                var button = findViewById<Button>(resources.getIdentifier(
                        "btn_${word_list[j]}", "id",
                        this.packageName
                    ))
                GlobalScope.launch {
                    button.text = newAlpha[word_list[j]]
                    delay(1000L)
                    return@launch
                }
                j+=1
            }
        }
    }
}
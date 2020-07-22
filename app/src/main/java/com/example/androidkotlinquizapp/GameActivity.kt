package com.example.androidkotlinquizapp

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View.INVISIBLE
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed
import kotlinx.android.synthetic.main.activity_game_recycler.*
import java.util.*
import kotlinx.coroutines.*
import java.lang.RuntimeException
import kotlin.concurrent.schedule
import kotlin.concurrent.thread

var numbers= arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26)
var numList= mutableListOf<Int>()
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

//        btn_25.setOnClickListener{
//            toastIt()
//        }


        btnPlay.setOnClickListener {

            var alphaList = mutableListOf<String>()
            for (i in 'A'..'Y') {
                alphaList.add(i.toString())
            }
            var newAlpha = alphaList.shuffled()
            var word_list = arrayOf(newAlpha.indexOf("C"), newAlpha.indexOf("A"), newAlpha.indexOf("T"))

            var j = 0
                while (j < word_list.size) {
                    numList.add(word_list[j])
                    try {
                        var button = findViewById<Button>(
                            resources.getIdentifier(
                                "btn_${word_list[j]}", "id",
                                this.packageName
                            )

                        )
                        runBlocking {
                            launch {
                                delay(500)
                                button.text = newAlpha[word_list[j]]
                                button.setOnClickListener{
                                    toastIt()
                                }
                            }
                        }
                        GlobalScope.async {
                                delay(5500)
                                button.text = ""
                        }
                        j+=1

                    }catch (e:InterruptedException){
                        e.printStackTrace()
                    }
                }
        }
    }

//    override fun onStart() {
//        super.onStart()
//
//        for (j in 1..numbers.size){
//            var button_new:Button? = findViewById<Button>(
//                resources.getIdentifier(
//                    "btn_${numbers[j]}", "id",
//                    this.packageName
//                )
//            )
//            button_new?.setOnClickListener{
//                for (y in 0..numList.size){
//                    if(button_new.id.equals("btn_${ numList[y]}")){
//                        Log.d("Clicked Button","Is equal")
//                    }
//                }
//            }
//
//        }
//    }

    private fun toastIt(){
        Toast.makeText(this,"I toasted it",Toast.LENGTH_LONG).show()
    }
}
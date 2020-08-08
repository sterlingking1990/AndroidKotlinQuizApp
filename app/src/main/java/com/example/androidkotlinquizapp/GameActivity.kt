package com.example.androidkotlinquizapp

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_recycler.*
import kotlinx.coroutines.*
import kotlin.system.exitProcess

var numbers= arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25)
var numList= mutableListOf<Int>()
var count=0;
var alphaList= mutableListOf<String>()
lateinit var pickedFourLetter:String
lateinit var userChoosenLetter:String
lateinit var newAlpha:List<String>
var number_of_times_clicked=0;
var number_of_times_correct=0;
var total_correctness=0
var threshHoldToNextLevel=0
var currentLevel=0
var life_line=4
var word_list= mutableListOf<Int>()
var handler=Handler()

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_recycler)
        for (i in 'A'..'Y') {
            alphaList.add(i.toString())
        }

        tvLifeLine.text= life_line.toString()
        tvScore.text= number_of_times_correct.toString()
        tvLevel.text= currentLevel.toString()

        btnPlay.setOnClickListener {
            //clear the buttons off the previous clicks and reset life line for next adventure if the life line is 0
            clearButtonText()
            //reset number of times clicked
            number_of_times_clicked=0
            number_of_times_correct=0
            if(life_line<=0){
                life_line=4
                number_of_times_correct=0
                tvScore.text= number_of_times_correct.toString()
                tvLifeLine.text= life_line.toString()
            }


            tvLevel.text= currentLevel.toString()

            newAlpha = alphaList.shuffled()
            var fourLetterWord = listOf<String>("FOUR", "CAKE", "FOAM", "FISH")
            var fiveLetterWord= listOf<String>("FREED","FRIED","CHOPS","PLAIN")
            var pickedNum = randomlyPick(fourLetterWord) { (it.indices).random() }
            //pick word randomly from wordsLevel
            pickedFourLetter = fourLetterWord.random()
            Toast.makeText(this, "Random text choose is $pickedFourLetter", Toast.LENGTH_SHORT)
                .show()

            //loop through each char in word and get the int position from shuffled letters

            for (element in pickedFourLetter) {
                Log.i("char_at_picked_is ", element.toString())
                word_list.add(newAlpha.indexOf(element.toString()))

            }
            Log.i("Length_Random_Word", word_list.toString())


            //loop through the index position of the randomly picked word and display on the button corresponding texts from the shuffled letters
            // corresponding to the index of the randomly picked word


            for (j in word_list.indices) {
                numList.add(word_list[j])
                Log.i("Word at ", newAlpha[word_list[j]])
                try {
                    var button = findViewById<Button>(
                        resources.getIdentifier(
                            "btn_${word_list[j]}", "id",
                            this.packageName
                        )

                    )
                    handler.postDelayed({
                        kotlin.run {
                            button.text = newAlpha[word_list[j]]
                        }
                    }, 500)

                    GlobalScope.async {
                        delay(5500)
                        button.text = ""
                    }
                } catch (e: InterruptedException) {

                }
            }


        }
    }


    fun randomlyPick(item: List<String>, randomly: (List<String>) -> Int): Int {
        return randomly(item)
    }

    fun btnCheckClicked(view: View) {
        if (number_of_times_clicked >= word_list.size || life_line<=0) {
            //now the user has clicked upto the length of random word choosen, tell the user to start the game afresh
            Toast.makeText(
                this,
                "You scored $number_of_times_correct out of $number_of_times_clicked  Press play Again",
                Toast.LENGTH_SHORT
            ).show()
            word_list.clear()
            return
        }

        var btnClick = findViewById<Button>(view.id).hasOnClickListeners()
        when (view.id) {

            R.id.btn_0 -> if (btnClick) {
                btn_0.text = newAlpha[0]
                if (btn_0.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()

                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }

            R.id.btn_1 -> if (btnClick) {
                btn_1.text = newAlpha[1]
                if (btn_1.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }

            R.id.btn_2 -> if (btnClick) {
                btn_2.text = newAlpha[2]
                if (btn_2.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_3 -> if (btnClick) {
                btn_3.text = newAlpha[3]
                if (btn_3.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_4 -> if (btnClick) {
                btn_4.text = newAlpha[4]
                if (btn_4.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }

            }
            R.id.btn_5 -> if (btnClick) {
                btn_5.text = newAlpha[5]
                if (btn_5.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_6 -> if (btnClick) {
                btn_6.text = newAlpha[6]
                if (btn_6.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_7 -> if (btnClick) {
                btn_7.text = newAlpha[7]
                if (btn_7.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }

            }
            R.id.btn_8 -> if (btnClick) {
                btn_8.text = newAlpha[8]
                if (btn_8.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_9 -> if (btnClick) {
                btn_9.text = newAlpha[9]
                if (btn_9.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_10 -> if (btnClick) {
                btn_10.text = newAlpha[10]
                if (btn_10.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_11 -> if (btnClick) {
                btn_11.text = newAlpha[11]
                if (btn_11.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_12 -> if (btnClick) {
                btn_12.text = newAlpha[12]
                if (btn_12.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_13 -> if (btnClick) {
                btn_13.text = newAlpha[13]
                if (btn_13.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_14 -> if (btnClick) {
                btn_14.text = newAlpha[14]
                if (btn_14.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_15 -> if (btnClick) {
                btn_15.text = newAlpha[15]
                if (btn_15.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_16 -> if (btnClick) {
                btn_16.text = newAlpha[16]
                if (btn_16.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_17 -> if (btnClick) {
                btn_17.text = newAlpha[17]
                if (btn_17.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_18 -> if (btnClick) {
                btn_18.text = newAlpha[18]
                if (btn_18.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_19 -> if (btnClick) {
                btn_19.text = newAlpha[19]
                if (btn_19.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_20 -> if (btnClick) {
                btn_20.text = newAlpha[20]
                if (btn_20.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }
            R.id.btn_21 -> if (btnClick) {
                btn_21.text = newAlpha[21]
                if (btn_21.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }

            }
            R.id.btn_22 -> if (btnClick) {
                btn_22.text = newAlpha[22]
                if (btn_22.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }

            }
            R.id.btn_23 -> if (btnClick) {
                btn_23.text = newAlpha[23]
                if (btn_23.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }

            }
            R.id.btn_24 -> if (btnClick) {
                btn_24.text = newAlpha[24]
                if (btn_24.text == newAlpha[word_list[number_of_times_clicked]]) {
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show()
                    number_of_times_correct+=1
                    total_correctness+=1
                    tvScore.text= total_correctness.toString()
                } else {
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show()
                    life_line-=1
                    tvLifeLine.text= life_line.toString()
                }
            }

            else -> Toast.makeText(this, "Nothing much", Toast.LENGTH_SHORT).show()
        }
        number_of_times_clicked += 1
    }



    private fun clearButtonText() {
        for (i in 0..26) {
            try {
                val button = findViewById<Button>(
                    resources.getIdentifier(
                        "btn_$i", "id",
                        this.packageName
                    )
                )

                button.text = ""
            } catch (e: Exception) {
                break
            }
        }
    }
}
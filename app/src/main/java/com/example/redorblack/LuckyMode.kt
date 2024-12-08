package com.example.redorblack

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityLuckyModeBinding

class LuckyMode : AppCompatActivity() {
    lateinit var binding: ActivityLuckyModeBinding
    lateinit var logic: Logic
    var cardCounter = 0
    var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        logic = Logic()






        //  Binding method for finding ID.
        binding = ActivityLuckyModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


       logic.shuffleCards(14)







        //  Red button.
        binding.redButtonLucky.setOnClickListener {
            guessCardColor("red")


        }


        //  Black button.
        binding.blackButtonLucky.setOnClickListener {
          guessCardColor("black")


        }



    }


    private fun guessCardColor(guessCard: String) {
        if (logic.guessCards(guessCard)) {
            cardCounter++
            score++

            binding.textView4.text = "Score: $score"
            logic.showCards(binding.imageView6)

            if (cardCounter == 14) {
                Toast.makeText(this, "You won!!", Toast.LENGTH_SHORT).show()
                buttonFunction.finalwiningScreen(this, score)
            } else {

                Toast.makeText(this, "Correct guessed!!", Toast.LENGTH_SHORT).show()
            }


        } else {

            Toast.makeText(this,"Wrong guessed!!", Toast.LENGTH_SHORT).show()
            buttonFunction.loseActivity(this,score)

        }


    }



}
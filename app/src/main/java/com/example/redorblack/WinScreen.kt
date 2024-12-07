package com.example.redorblack

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityWinScreenBinding

class WinScreen : AppCompatActivity() {

    lateinit var binding: ActivityWinScreenBinding
    var cardCounter = 0
    var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        //  Binding method for finding ID.
        binding = ActivityWinScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




         score = intent.getIntExtra("Score",0)
        cardCounter= intent.getIntExtra("cardCaounter",cardCounter)


        binding.textViewWin.text = "Score: $score"




        //  Red button.
        binding.button.setOnClickListener {


            guessCardColor("red")


        }



        //  Black button.
        binding.button2.setOnClickListener {

            guessCardColor("black")

        }


    }


    private fun guessCardColor(guessCard: String) {
        if (ObjLogic.guessCards(guessCard)) {
            cardCounter++
            score++

            ObjLogic.showCards(binding.imageView3)

            if (cardCounter == 4) {
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
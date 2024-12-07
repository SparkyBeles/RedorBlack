package com.example.redorblack
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityEasyModeBinding
import kotlin.math.log


class EasyMode : AppCompatActivity() {
    //  Global instance
    lateinit var binding: ActivityEasyModeBinding
    var cardCounter = 0
    var score = 0







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)






        //  Binding method for finding ID.
        binding = ActivityEasyModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //  First Image in imageview is a defaultCard without color.
        ObjLogic.shuffleCards(4)



        binding.textView2.text = "Score: $score"






        //  Red button
        binding.redButton.setOnClickListener {

            guessCardColor("red")

        }


        //  Black button.
        binding.blackButton.setOnClickListener {

            guessCardColor("black")

        }


    }


    private fun guessCardColor(guessCard: String) {
        if (ObjLogic.guessCards(guessCard)) {
            ObjLogic.showCards(binding.imageView)
            cardCounter++
            score++
            binding.textView2.text = "Score: $score"


            if (cardCounter == 4) {
                Toast.makeText(this, "You won!!", Toast.LENGTH_SHORT).show()
                buttonFunction.finalwiningScreen(this, score)
            } else {

               Toast.makeText(this, "Correct guessed!!", Toast.LENGTH_SHORT).show()
            }


        } else {

            Toast.makeText(this,"Wrong guessed!!",Toast.LENGTH_SHORT).show()
            buttonFunction.loseActivity(this,score)

        }


    }
}



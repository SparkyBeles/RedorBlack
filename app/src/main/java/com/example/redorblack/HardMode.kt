package com.example.redorblack
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityHardModeBinding

class HardMode : AppCompatActivity() {
    lateinit var binding: ActivityHardModeBinding
    lateinit var card: Card
    var cardCounter = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        //  Binding method for finding ID.
        binding = ActivityHardModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        score = intent.getIntExtra("Score",score)
        cardCounter = intent.getIntExtra("cardCounter",cardCounter)




        ObjLogic.shuffleCards(8)










       ObjLogic.showCards(binding.imageView4)





        //  Red button.
        binding.redButtonHard.setOnClickListener {
            guessCardColor("red")



        }



        //  Black button.
        binding.blackButtonHard.setOnClickListener {

            guessCardColor("black")


        }

    }


    private fun guessCardColor(guessCard: String) {
        if (ObjLogic.guessCards(guessCard)) {
            cardCounter++
            score++

            ObjLogic.showCards(binding.imageView4)

            if (cardCounter == 8) {
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
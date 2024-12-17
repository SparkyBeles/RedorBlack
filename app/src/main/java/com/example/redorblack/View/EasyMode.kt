package com.example.redorblack.View
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.redorblack.R
import com.example.redorblack.Utils.buttonFunction
import com.example.redorblack.ViewModel.Logic
import com.example.redorblack.databinding.ActivityEasyModeBinding


class EasyMode : AppCompatActivity() {
    //  Global instance
    private lateinit var viewModel: Logic
    lateinit var binding: ActivityEasyModeBinding
    var cardCounter = 0
    var score = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        viewModel = ViewModelProvider(this)[Logic::class.java]







        //  Binding method for finding ID.
        binding = ActivityEasyModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        viewModel.currentCardLiveData.observe(this){card ->
            card?.let {
                binding.imageView.setImageResource(card.cardValue)
            }
        }



      viewModel.shuffleCards(5)











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
        if (viewModel.guessCards(guessCard)) {
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
            buttonFunction.loseActivity(this, score)

        }


    }
}



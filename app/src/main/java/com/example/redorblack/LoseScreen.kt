package com.example.redorblack
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityLoseScreenBinding

class LoseScreen : AppCompatActivity() {

    lateinit var binding: ActivityLoseScreenBinding
    var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        //  Binding method for finding ID.
        binding = ActivityLoseScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        score = intent.getIntExtra("Score",score)


        //  Text view for the score.
        binding.textViewLose.text = "Score: $score"







        //  Green button Restart.
        binding.button3.setOnClickListener {
            buttonFunction.restartButton(this)


        }


        // Red button Quit.
        binding.button4.setOnClickListener {
           buttonFunction.quitButton(this)

        }



    }



}
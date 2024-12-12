package com.example.redorblack
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.redorblack.databinding.ActivityFinalWiningScreenBinding

class FinalWiningScreen : AppCompatActivity() {

    lateinit var binding: ActivityFinalWiningScreenBinding
    var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)



        //  Binding method for finding ID.
        binding = ActivityFinalWiningScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        score = intent.getIntExtra("Score",0)
        binding.textView.text = "Score: $score"



        //  Trying to make the gif work.
      val image =  binding.imageView5

        Glide.with(this).load(R.drawable.winner).into(image)








        //  Restart button.
        binding.button5.setOnClickListener {
           buttonFunction.restartButton(this)


        }


        //  Quit button.
        binding.button6.setOnClickListener {
            buttonFunction.quitButton(this)

        }

    }




}
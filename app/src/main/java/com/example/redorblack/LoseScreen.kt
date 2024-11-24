package com.example.redorblack

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityLoseScreenBinding

class LoseScreen : AppCompatActivity() {

    lateinit var binding: ActivityLoseScreenBinding
    lateinit var card: Card

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




        //  First Image in imageview is a defaultCard without color.
        binding.imageView2.setImageResource(R.mipmap.defaultcard)




        //  Green button Restart.
        binding.button3.setOnClickListener {

            binding.imageView2.setImageResource(card.cardValue)
            intent = Intent(this, ModeOption::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
           startActivity(intent)
            finish()


        }


        // Red button Quit.
        binding.button4.setOnClickListener {
            finishAffinity()

        }



    }



}
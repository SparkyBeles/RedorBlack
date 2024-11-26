package com.example.redorblack

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityHardModeBinding
import com.example.redorblack.databinding.ActivityLuckyModeBinding

class HardMode : AppCompatActivity() {
    lateinit var binding: ActivityHardModeBinding
    lateinit var card: Card

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











        //  First Image in imageview is a defaultCard without color.
        binding.imageView4.setImageResource(R.mipmap.defaultcard)





        //  Red button.
        binding.redButtonHard.setOnClickListener {
            binding.imageView4.setImageResource(card.cardValue)

            card.checkCard("red",this)

        }



        //  Black button.
        binding.blackButtonHard.setOnClickListener {

            card.checkCard("black",this)

        }

    }



}
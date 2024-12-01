package com.example.redorblack

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityLuckyModeBinding

class LuckyMode : AppCompatActivity() {
    lateinit var binding: ActivityLuckyModeBinding
    lateinit var card: Card


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        //  Binding method for finding ID.
        binding = ActivityLuckyModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }













        binding.imageView6.setImageResource(R.mipmap.defaultcard)









        //  Red button.
        binding.redButtonLucky.setOnClickListener {
            binding.imageView6.setImageResource(card.cardValue)


        }


        //  Black button.
        binding.blackButtonLucky.setOnClickListener {
            binding.imageView6.setImageResource(card.cardValue)


        }



    }




}
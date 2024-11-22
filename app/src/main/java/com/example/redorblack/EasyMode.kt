package com.example.redorblack

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityEasyModeBinding
import kotlin.random.Random

class EasyMode : AppCompatActivity() {
    lateinit var binding: ActivityEasyModeBinding


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


        //  Cardlist
        val cardList = listOf(
            R.mipmap.blackcard0,
            R.mipmap.blackcard1,
            R.mipmap.blackcard2,
            R.mipmap.blackcard3,
            R.mipmap.blackcard4,
            R.mipmap.blackcard5,
            R.mipmap.blackcard6,
            R.mipmap.redcard0,
            R.mipmap.redcard1,
            R.mipmap.redcard2,
            R.mipmap.redcard3,
            R.mipmap.redcard4,
            R.mipmap.redcard5,
            R.mipmap.redcard6,
            )


       //  random function for the cards.
        val randomCards = cardList.shuffled().take(3)



        val firstCard = randomCards[0]
        val secondCard = randomCards[1]
        val thirdCard = randomCards[2]


        //  Testing card functions.
        val listOfRandomCards = listOf(firstCard,secondCard,thirdCard)
        var currentCardIndex = 0
        fun showCards(imageView: ImageView){
            imageView.setImageResource(randomCards[0])

        }





        //  Red button
        binding.redButton.setOnClickListener {

        }


        //  Black button.
        binding.blackButton.setOnClickListener {

        }




    }








}
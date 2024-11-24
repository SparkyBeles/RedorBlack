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


class EasyMode : AppCompatActivity() {
    lateinit var binding: ActivityEasyModeBinding
    lateinit var cardManager: CardManager
    lateinit var card: Card



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        cardManager = CardManager()




        //  Binding method for finding ID.
        binding = ActivityEasyModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //  CardList
        val cardList = listOf(
            Card("red",R.mipmap.redcard0),
            Card("red",R.mipmap.redcard1),
            Card("red",R.mipmap.redcard2),
            Card("red",R.mipmap.redcard3),
            Card("red",R.mipmap.redcard4),
            Card("red",R.mipmap.redcard5),
            Card("red",R.mipmap.redcard6),
            Card("black",R.mipmap.blackcard0),
            Card("black",R.mipmap.blackcard1),
            Card("black",R.mipmap.blackcard2),
            Card("black",R.mipmap.blackcard3),
            Card("black",R.mipmap.blackcard4),
            Card("black",R.mipmap.blackcard5),
            Card("black",R.mipmap.blackcard6),

            )

        val shuffledCards = cardList.shuffled().take(3)

        card = shuffledCards.first()

        binding.imageView.setImageResource(card.cardValue)


        fun checkCard(guessColor: String){
            if (guessColor == card.color){
                intent = Intent(this,WinScreen::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }else{
                intent = Intent(this, LoseScreen::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }

        }


        //  Red button
        binding.redButton.setOnClickListener {

            checkCard("red")

        }


        //  Black button.
        binding.blackButton.setOnClickListener {
            checkCard("black")

        }


    }




}
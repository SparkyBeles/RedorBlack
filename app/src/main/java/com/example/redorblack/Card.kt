package com.example.redorblack

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import com.example.redorblack.databinding.ActivityEasyModeBinding

//  Card parameter.
class Card(val color: String, val cardValue: Int) {


    // Method for showing the card in ImageView.
    fun showCard(imageView: ImageView) {
        imageView.setImageResource(cardValue)
    }

    // Method for checking if the guessed color matches the card's color.
    fun checkGuess(guessColor: String): Boolean {
        return color == guessColor
    }

    // Method for showing current card and updating the ImageView.
    fun showCurrentCard(
        shuffledCards: List<Card>,
        currentCardIndex: Int,
        binding: ActivityEasyModeBinding
    ) {
        if (currentCardIndex < shuffledCards.size) {
            shuffledCards[currentCardIndex].showCard(binding.imageView)
        }
    }

    // Method for handling the win screen intent.
    fun showWinScreen(context: Context) {
        val intent = Intent(context, WinScreen::class.java)
        context.startActivity(intent)
    }

    // Method for handling the lose screen intent.
    fun showLoseScreen(context: Context) {
        val intent = Intent(context, LoseScreen::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)
    }

}







class CardManager {


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
}
package com.example.redorblack

import android.content.Intent
import android.content.Context

//  Card parameter.
data class Card(val color: String, val cardValue: Int) {


    fun checkCard(guessColor: String, context: Context) {
      val intent = if (guessColor == color) {
            Intent(context, WinScreen::class.java)
        } else {

            Intent(context, LoseScreen::class.java)
        }
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(intent)

        if (context is android.app.Activity){
            context.finish()
        }

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
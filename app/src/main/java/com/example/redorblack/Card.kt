package com.example.redorblack

//  Card parameter.
data class Card(val color: String, val cardValue: Int) {}





open class CardManager {


    //  CardList
    val cardList = mutableListOf(
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
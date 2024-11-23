package com.example.redorblack

//  Card parameter.
class Card(val color: String, val cardValue: Int)

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

    //  Different amount of card shuffled for different mode.
    fun shuffleEasyCard() = cardList.shuffled().take(3)
    fun shuffleHardCard() = cardList.shuffled().take(6)
    fun shuffleLuckyCards() = cardList.shuffled().take(12)

    //  Method for checking the card color and counting cards.
    fun checkCard(){}

    //  Method for showing the card in imageview.
    fun showCard(){}

    //  Method for keeping track of points.
    fun pointTracer(){}









}
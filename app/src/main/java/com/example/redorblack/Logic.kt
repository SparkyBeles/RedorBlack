package com.example.redorblack

import android.widget.ImageView

open class Logic : CardManager() {

    private val shuffledCard = mutableListOf<Card>()
    private var currentCard = 0


  //  Shuffle Method for the card list.
    fun shuffleCards(cardAmount : Int){
        shuffledCard.clear()
        shuffledCard.addAll(cardList.shuffled().take(cardAmount))
        currentCard = 0


    }

    //  Deal card method.
    fun dealCards(): Card? {
        return if (currentCard > 0 && currentCard < shuffledCard.size) {
            shuffledCard[currentCard - 1]
        } else if (shuffledCard.isNotEmpty()) {
            shuffledCard[0]
        } else {
            null
        }

    }



    // Showcard method that show the card being guessed on.
    fun showCards(imageView: ImageView): Boolean{
        return if (currentCard < shuffledCard.size) {
            val card = shuffledCard[currentCard]
            imageView.setImageResource(card.cardValue)
            imageView.postDelayed({
                imageView.setImageResource(R.mipmap.defaultcard)
            },1000)

            currentCard++
            true

        }else{
            false
        }
    }


//  Guess method.
    fun guessCards(guessCard : String): Boolean{
        val currentCard = dealCards()
        if (currentCard != null){
            return currentCard.color.equals(guessCard)
        }else{
            return false
        }
    }






}
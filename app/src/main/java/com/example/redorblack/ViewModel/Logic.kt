package com.example.redorblack.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redorblack.Model.Card
import com.example.redorblack.Model.CardManager

class Logic : ViewModel(){

    private val cardManager = CardManager()
    private val shuffledCard = mutableListOf<Card>()
    private var currentCard = 0



    //  LiveData observer
    private val _currentCardLiveData = MutableLiveData<Card?>()
    val currentCardLiveData: LiveData<Card?> get() = _currentCardLiveData



  //  Shuffle Method for the card list.
    fun shuffleCards(cardAmount : Int){
        shuffledCard.clear()
        shuffledCard.addAll(cardManager.cardList.shuffled().take(cardAmount))
        currentCard = 0

    }







//  Guess method.
    fun guessCards(guessCard : String): Boolean{
        if (currentCard < shuffledCard.size){
           val card = shuffledCard[currentCard]
            _currentCardLiveData.value = card
            currentCard++
            return card.color.equals(guessCard, ignoreCase = true)
        }
            return false
        }
    }







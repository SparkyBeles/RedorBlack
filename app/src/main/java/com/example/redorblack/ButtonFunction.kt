package com.example.redorblack

import android.app.Activity
import android.content.Context
import android.content.Intent


object buttonFunction {

    fun aboutButton(context: Context){
        val aboutIntent = Intent(context, About::class.java)
        aboutIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(aboutIntent)
        if (context is Activity){
            context.finish()
        }

    }



    fun restartButton(context: Context){
        val restartIntent = Intent(context, ModeOption::class.java)
        restartIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(restartIntent)
        if (context is Activity){
            context.finish()
        }
    }


    fun quitButton(context: Context){
        if (context is Activity){
            context.finishAffinity()
        }else{
            throw IllegalArgumentException("Have to be A Activity!")

        }

    }


    fun winActivity(context: Context){
        val winIntent = Intent(context, WinScreen::class.java )
        winIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(winIntent)
        if (context is Activity){
            context.finish()
        }
    }


    fun loseActivity (context: Context){
        val loseIntent = Intent(context, LoseScreen::class.java)
        loseIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(loseIntent)
        if (context is Activity){
            context.finish()
        }

    }


    fun dissMissButton(context: Context){
        val dismissIntent = Intent(context, MainActivity::class.java)
        dismissIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(dismissIntent)
        if (context is Activity){
            context.finish()

        }
    }





}
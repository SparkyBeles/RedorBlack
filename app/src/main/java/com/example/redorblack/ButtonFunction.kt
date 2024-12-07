package com.example.redorblack

import android.app.Activity
import android.content.Context
import android.content.Intent


object buttonFunction {

    fun aboutButton(context: Context) {
        val aboutIntent = Intent(context, About::class.java)
        aboutIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(aboutIntent)
        if (context is Activity) {
            context.finish()
        }

    }


    fun restartButton(context: Context) {
        val restartIntent = Intent(context, ModeOption::class.java)
        restartIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(restartIntent)
        if (context is Activity) {
            context.finish()
        }
    }


    fun quitButton(context: Context) {
        if (context is Activity) {
            context.finishAffinity()
        } else {
            throw IllegalArgumentException("Have to be A Activity!")

        }

    }


    fun loseActivity(context: Context, score: Int) {
        val loseIntent = Intent(context, LoseScreen::class.java)
        loseIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        loseIntent.putExtra("Score", score)
        context.startActivity(loseIntent)
        if (context is Activity) {
            context.finish()
        }

    }


    fun dissMissButton(context: Context) {
        val dismissIntent = Intent(context, MainActivity::class.java)
        dismissIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(dismissIntent)
        if (context is Activity) {
            context.finish()

        }
    }


    fun finalwiningScreen(context: Context, score: Int) {
        val finalWinIntent = Intent(context, FinalWiningScreen::class.java)
        finalWinIntent.putExtra("Score", score)
        finalWinIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(finalWinIntent)
        if (context is Activity) {
            context.finish()
        }
    }


    fun easyMode(context: Context) {
        val easyIntent = Intent(context, EasyMode::class.java)
        easyIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(easyIntent)
        if (context is Activity) {
            context.finish()
        }

    }


    fun hardMode(context: Context) {
        val hardIntent = Intent(context, EasyMode::class.java)
        hardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(hardIntent)
        if (context is Activity) {
            context.finish()
        }

    }

    fun luckyMode(context: Context) {
        val luckyIntent = Intent(context, EasyMode::class.java)
        luckyIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        context.startActivity(luckyIntent)
        if (context is Activity) {
            context.finish()

        }

    }

}

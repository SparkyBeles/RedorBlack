package com.example.redorblack

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityGameLogicBinding

class GameLogic : AppCompatActivity() {

    lateinit var binding: ActivityGameLogicBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityGameLogicBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val redCards = listOf(
            R.mipmap.redcard0,
            R.mipmap.redcard1,
            R.mipmap.redcard2,
            R.mipmap.redcard3,
            R.mipmap.redcard4,
            R.mipmap.redcard5,
            R.mipmap.redcard6
        )


        val blackCards = listOf(
            R.mipmap.blackcard0,
            R.mipmap.blackcard1,
            R.mipmap.blackcard2,
            R.mipmap.blackcard3,
            R.mipmap.blackcard4,
            R.mipmap.blackcard5,
            R.mipmap.blackcard6,

            )







    }






}
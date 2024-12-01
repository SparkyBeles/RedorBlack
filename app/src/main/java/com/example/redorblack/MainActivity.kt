package com.example.redorblack

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)




        //  Binding method for finding ID.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }








   // Start button
    binding.startButton.setOnClickListener{
      buttonFunction.restartButton(this)
    }



    // Quit button
    binding.quitButton.setOnClickListener{
        buttonFunction.quitButton(this)
    }


    //  About button.
    binding.aboutButton.setOnClickListener{
        buttonFunction.aboutButton(this)
    }







    }




}
package com.example.redorblack

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityModeOptionBinding

class ModeOption : AppCompatActivity() {

    lateinit var binding: ActivityModeOptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)



        //  Binding method for finding ID.
        binding = ActivityModeOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        //  Easy mode button
        binding.easyButtonMode.setOnClickListener {
            val intent = Intent(this, EasyMode::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()

        }



        //  Hard mode button.
        binding.hardButtonMode.setOnClickListener {
            val intent = Intent(this, HardMode::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()

        }

        //  Lucky mode button.
        binding.luckyButtonMode.setOnClickListener {
            val intent = Intent(this, LuckyMode::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()

        }







    }








}
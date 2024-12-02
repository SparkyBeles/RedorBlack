package com.example.redorblack
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.redorblack.databinding.ActivityEasyModeBinding


class EasyMode : AppCompatActivity() {
    //  Global instance
    lateinit var binding: ActivityEasyModeBinding
    lateinit var cardManager: CardManager






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //  Screen Orientation lock on portrait.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)




        // local Instance of cardManager.
        cardManager = CardManager()


        //  Binding method for finding ID.
        binding = ActivityEasyModeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }








        //  First Image in imageview is a defaultCard without color.
        binding.imageView.setImageResource(R.mipmap.defaultcard)







        //  Red button
        binding.redButton.setOnClickListener {

        }


        //  Black button.
        binding.blackButton.setOnClickListener {

        }


    }




}



package com.tahacinar.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tahacinar.storingdata.databinding.ActivityMainBinding
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.tahacinar.storingdata", Context.MODE_PRIVATE)

        val userAgePref = sharedPref.getInt("age",-1)

        if(userAgePref == 1) {
            binding.textView.text = "Your Age:"
        } else {
            binding.textView.text = "Your Age: ${userAgePref}"
        }

    }

    fun save (view:View){



    }
    fun delete (view:View){

    }


}
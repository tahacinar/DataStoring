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
    var ageFromPref : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = this.getSharedPreferences("com.tahacinar.storingdata", Context.MODE_PRIVATE)

        val ageFromPref = sharedPref.getInt("age",0)

        if(ageFromPref == 1) {
            binding.textView.text = "Your Age:"
        } else {
            binding.textView.text = "Your Age: ${ageFromPref}"
        }

    }

    fun save (view:View){
        val myAge = binding.editText.text.toString().toIntOrNull()

        if (myAge != null) {
            binding.textView.text = "Your age: ${myAge}"
            sharedPref.edit().putInt("age",myAge).apply()
        }


    }
    fun delete (view:View){

        ageFromPref = sharedPref.getInt("age",-1)

        if (ageFromPref != -1) {
            sharedPref.edit().remove("age").apply()
            binding.textView.text = " Your age:"
        }


    }


}
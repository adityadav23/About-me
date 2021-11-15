package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //Data class object
    private val myName: MyName = MyName("Aditya Yadav")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        //Using binding object to reference doneButton
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }


    private fun addNickname(view: View){

        // Using binding.apply() to mske it easier to read
       binding.apply {
          myName?.nickname = editTextTextPersonName.text.toString()
           //invalidate all views to recreate views with correct data
           invalidateAll()
           editTextTextPersonName.visibility = View.GONE
           view.visibility = View.GONE
           nicknameText.visibility = View.VISIBLE

       }

        //Code to hide on screen keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken , 0)

    }
}
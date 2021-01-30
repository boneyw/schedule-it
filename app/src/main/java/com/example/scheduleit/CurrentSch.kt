package com.example.scheduleit

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class CurrentSch : AppCompatActivity(){

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.currentsch)

        val thedate = findViewById<Button>(R.id.btnNewApp)
        val setApp = SetApp()


        thedate.setOnClickListener {
            setApp.clickDataPicker()
        }

    }
}
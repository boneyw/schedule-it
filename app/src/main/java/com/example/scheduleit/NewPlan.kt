package com.example.scheduleit

import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class NewPlan: AppCompatActivity(){

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newplan)

        val thedate = findViewById<Button>(R.id.btnDate)
        val setApp = SetApp()


        thedate.setOnClickListener { setApp.clickDataPicker() }
    }
}
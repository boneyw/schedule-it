package com.example.scheduleit

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import androidx.annotation.RequiresApi


class Cal : AppCompatActivity()  {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal)

        val thedate = findViewById<Button>(R.id.btnNewApp)
        val setApp = SetApp()

        thedate.setOnClickListener {
            setApp.clickDataPicker()
        }
    }
}
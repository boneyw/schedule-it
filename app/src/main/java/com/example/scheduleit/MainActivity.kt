package com.example.scheduleit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getApplicationContext()



        val calen = findViewById<Button>(R.id.btnCal)
        val curr = findViewById<Button>(R.id.btnCurrApp)
        val newpla = findViewById<Button>(R.id.btnSetNew)
        val exitapp = findViewById<Button>(R.id.btnExit)

        calen.setOnClickListener{
            val intent = Intent(this, Cal::class.java)
            startActivity(intent)
        }
        curr.setOnClickListener {
            val intent = Intent( this, CurrentSch:: class.java)
            startActivity(intent)
        }
        newpla.setOnClickListener{
            val intent = Intent(this, NewPlan::class.java)
            startActivity(intent)
        }

        exitapp.setOnClickListener {
            finish()
            exitProcess(0)
        }
    }

}
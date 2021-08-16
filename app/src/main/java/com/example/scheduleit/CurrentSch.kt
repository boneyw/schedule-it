package com.example.scheduleit

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.currentsch.*

class CurrentSch : AppCompatActivity(){


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.currentsch)

        btnNewApp2.setOnClickListener {
            val intent = Intent(this, NewPlan::class.java)
            startActivity(intent)
        }
        
        seeAllEventInPlan()

    }

    private fun getEventist(): ArrayList<EventModelk>{
        val eventdatabase = EventDatabasek(this)

        return eventdatabase.veiwEvent()
    }

    fun seeAllEventInPlan() = if(getEventist().size >0){

        ryc_eventLists.visibility = View.VISIBLE
        viewnotview.visibility = View.GONE

        ryc_eventLists.layoutManager = LinearLayoutManager(this)
        val eventAdapter = EventAdapter(this, getEventist())
        ryc_eventLists.adapter = eventAdapter

    }else{
        ryc_eventLists.visibility = View.GONE
        viewnotview.visibility = View.VISIBLE
    }
}
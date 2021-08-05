package com.example.scheduleit


import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CurrentSch : AppCompatActivity(){

    private lateinit var linearLayoutManager: LinearLayoutManager

     val eventlist: RecyclerView? = findViewById(R.id.ryc_eventLists)

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

    private fun getEventist(): ArrayList<EventModelk>{
        val eventdatabase = EventDatabasek(this)

        val evtlist: ArrayList<EventModelk> = eventdatabase.veiwEvent()

        return evtlist
    }

    private fun seeAllEventInPlan(){
        if(getEventist().size >0){
            eventlist?.visibility = View.VISIBLE

            eventlist?.layoutManager = LinearLayoutManager(this)

            eventlist?.layoutManager = LinearLayoutManager(this)

            val eventAdapter = EventAdapter(this, getEventist())

            eventlist?.adapter = eventAdapter

        }else{
            eventlist?.visibility = View.GONE
        }
    }
}
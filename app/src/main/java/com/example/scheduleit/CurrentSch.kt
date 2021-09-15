package com.example.scheduleit

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.currentsch.*
import kotlinx.android.synthetic.main.eventitems.*

class CurrentSch : AppCompatActivity(), EventAdapter.onItemClickListener {

    //private var change =imageView2?.isClickable
    var STORAGE_LOCAL =true

    val eventlist = ArrayList<EventModelk>()

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

    //private var change =imageView2?.isClickable

    private fun getEventist(): ArrayList<EventModelk>{
        val eventdatabase = EventDatabasek(this)

        return eventdatabase.veiwEvent()
    }

    fun seeAllEventInPlan() = if(getEventist().size >0){

        ryc_eventLists.visibility = View.VISIBLE
        viewnotview.visibility = View.GONE

        ryc_eventLists.layoutManager = LinearLayoutManager(this)
        val eventAdapter = EventAdapter(this,this, getEventist())
        ryc_eventLists.adapter = eventAdapter

    }else{
        ryc_eventLists.visibility = View.GONE
        viewnotview.visibility = View.VISIBLE
    }
    override fun onItemClick(position: Int) {

        val item = eventlist[position]
        img_edit.setOnClickListener {
            val intent = Intent(this, UpdateDataInfo::class.java)
            intent.putExtra("Events", position)
            startActivity(intent)
        }
    }
}
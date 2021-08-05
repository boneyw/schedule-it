package com.example.scheduleit

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class EventAdapter (val context: Context, val items: ArrayList<EventModelk>):
        RecyclerView.Adapter<EventAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.eventitems,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = items[position]

        holder.oneemail.text = item.eEmail
        holder.onenote.text = item.nNotes

//        if (position % 2 ==0){
//            holder.IIMain.setBackgroungColor(Color.parseColor(R.color.colorLightGray.toString()))
//
//        }else{
//            holder.IIMain.setBackgroundColor(ContextCompat.getColor(context,R.color.colorWhite))
//        }
    }

    override fun getItemCount(): Int {
    return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val IIMain: LayoutInflater = view.findViewById(R.id.IIMain)
        val setisdate:TextView = view.findViewById(R.id.set_date)
        val oneTime: TextView = view.findViewById(R.id.set_time)
        val onecheck: TextView = view.findViewById(R.id.is_repeat)
        val oneemail: TextView = view.findViewById(R.id.Tv_email)
        val onenote: TextView = view.findViewById(R.id.set_note)
        val oneEdit : ImageView = view.findViewById(R.id.img_edit)
        val oneDelete : ImageView = view.findViewById(R.id.imageView2)



    }

}

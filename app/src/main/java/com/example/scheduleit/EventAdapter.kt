package com.example.scheduleit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.eventitems.view.*


class EventAdapter(var mListener: onItemClickListener, var context: Context, val items: ArrayList<EventModelk>):
        RecyclerView.Adapter<EventAdapter.ViewHolder>()  {



    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {



            val itemview = LayoutInflater.from(context).inflate(
                R.layout.eventitems,
                parent,
                false,
            )
        return ViewHolder(itemview, mListener)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = items[position]

        holder.setEmail.text = item.eEmail
        holder.setNotes.text = item.nNotes
        holder.setData.text = item.dDate
        holder.setTime.text = item.tTime
        if (item.repeat == 1) {

            holder.setReap.isChecked = true
            // holder.setReap.text = item.repeat.toString()
        }

        if (position % 2 == 0) {
            holder.main.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorLightGray
                )
            )
        } else {
            holder.main.setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhite))
        }
        holder.pushimg.setOnClickListener {

        }
      holder.pushimg.setOnClickListener { mListener.onItemClick(position) }
    }

    override fun getItemCount(): Int {
    return items.size
    }

    class ViewHolder(view: View,onItemClickListener: onItemClickListener): RecyclerView.ViewHolder(view),onItemClickListener {

        val main: CardView = view.IIMain
        val setData: TextView = view.set_date
        val setTime: TextView = view.set_time
        val setEmail: TextView = view.Tv_email
        val setNotes: TextView = view.set_note
        val setReap: CheckBox =view.is_repeat
        val pushimg: ImageView = view.img_edit
        val onItemClickListener = onItemClickListener


        override fun onItemClick(position: Int) {
            onItemClickListener.onItemClick(absoluteAdapterPosition)
        }

    }
}

package com.vinyls.mobile.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vinyls.mobile.R
import com.vinyls.mobile.model.Track

class TrackListAdapter(
    val list:List<Track?>,
    val context: Context
) : RecyclerView.Adapter<TrackListAdapter.ViewHolder>(){

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItem(item: Track?) {

            var name = itemView.findViewById(R.id.nameTrackView) as TextView
            name.text = item?.name

            var duration = itemView.findViewById(R.id.nameDurationView) as TextView
            duration.text = item?.duration

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_track_item, parent, false)
        return TrackListAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}


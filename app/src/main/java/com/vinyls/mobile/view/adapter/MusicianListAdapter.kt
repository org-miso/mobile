package com.vinyls.mobile.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vinyls.mobile.R
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.model.Musician

class MusicianListAdapter(
        val list:List<Musician?>,
        val context: Context
    ) : RecyclerView.Adapter<MusicianListAdapter.ViewHolder>(){

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItem(item: Musician?) {

            var imageView = itemView.findViewById(R.id.image) as ImageView
            Picasso.get().load(item?.image).into(imageView)

            var titleName = itemView.findViewById(R.id.nameMusicianView) as TextView
            titleName.text = item?.name

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_musician_item, parent, false)
        return MusicianListAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
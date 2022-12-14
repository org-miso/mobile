package com.vinyls.mobile.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.vinyls.mobile.R
import com.vinyls.mobile.model.Musician
import com.vinyls.mobile.view.AlbumDetailActivity
import com.vinyls.mobile.view.ArtistDetailActivity

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
        holder.itemView.setOnClickListener(){
            val intent = Intent(this.context, ArtistDetailActivity::class.java)
            intent.putExtra("title", list[position]?.name)
            intent.putExtra("image", list[position]?.image)
            intent.putExtra("description", list[position]?.description)
            this.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
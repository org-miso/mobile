package com.vinyls.mobile.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import com.vinyls.mobile.R
import com.vinyls.mobile.model.Album

class AlbumListAdapter(
    val list:List<Album?>,
    val context: Context
) : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {

    class ViewHolder(
        val itemView: View
    ):RecyclerView.ViewHolder(itemView){

        fun bindItem(album: Album?) {
            var imageView = itemView.findViewById(R.id.imageAlbum) as ImageView
            Picasso.get().load(album?.cover).into(imageView);

            var albumName = itemView.findViewById(R.id.textViewAlbum) as TextView
            albumName.text = album?.name

            var albumYear = itemView.findViewById(R.id.yearViewAlbum) as TextView
            albumYear.text = album?.year?.substring(0,4)

            var albumDescription = itemView.findViewById(R.id.descriptionViewAlbum) as TextView
            albumDescription.text = "Descripción: " + album?.description?.substring(0,140) + "..."
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_album_item, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}


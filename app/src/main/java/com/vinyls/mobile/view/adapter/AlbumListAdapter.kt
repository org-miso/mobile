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
import com.vinyls.mobile.model.Album
import com.vinyls.mobile.view.AlbumDetailActivity

class AlbumListAdapter(
    val list:List<Album?>,
    val context: Context
) : RecyclerView.Adapter<AlbumListAdapter.ViewHolder>() {

    class ViewHolder(
        val itemView: View
    ):RecyclerView.ViewHolder(itemView){

        fun bindItem(album: Album?) {
            var imageView = itemView.findViewById(R.id.imageAlbum) as ImageView
            Picasso.get().load(album?.cover).into(imageView)

            var albumName = itemView.findViewById(R.id.textViewAlbum) as TextView
            albumName.text = album?.name

            var albumYear = itemView.findViewById(R.id.yearViewAlbum) as TextView
            albumYear.text = album?.year

            var albumDescription = itemView.findViewById(R.id.descriptionViewAlbum) as TextView
            if(album?.description?.length!! > 140){
                albumDescription.text = "Descripción: " + album?.description?.substring(0,140) + "..."
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_album_item, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
        holder.itemView.setOnClickListener(){
            val intent = Intent(this.context, AlbumDetailActivity::class.java)
            intent.putExtra("nameAlbum", list[position]?.name)
            intent.putExtra("coverAlbum", list[position]?.cover)
            intent.putExtra("genreAlbum", list[position]?.genre)
            intent.putExtra("recordLabelAlbum", list[position]?.recordLabel)
            intent.putExtra("releaseDateAlbum", list[position]?.releaseDate)
            intent.putExtra("descriptionAlbum", list[position]?.description)
            intent.putExtra("idAlbum", list[position]?.id)
            intent.putExtra("tracksAlbum", Gson().toJson(list[position]?.tracks))
            this.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }



}


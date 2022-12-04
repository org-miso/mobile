package com.vinyls.mobile.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.vinyls.mobile.R
import com.vinyls.mobile.model.Collector
import com.vinyls.mobile.view.CollectorDetailActivity

class CollectorListAdapter(
        val list:List<Collector?>,
        val context: Context
    ) : RecyclerView.Adapter<CollectorListAdapter.ViewHolder>(){

    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItem(item: Collector?) {

            var name = itemView.findViewById(R.id.name) as TextView
            name.text = item?.name

            var email = itemView.findViewById(R.id.email) as TextView
            email.text = item?.email

            var telephone = itemView.findViewById(R.id.phone) as TextView
            telephone.text = item?.telephone

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_collector_item, parent, false)
        return CollectorListAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
        holder.itemView.setOnClickListener(){
            val intent = Intent(this.context, CollectorDetailActivity::class.java)
            intent.putExtra("name", list[position]?.name)
            intent.putExtra("id", list[position]?.id)
            intent.putExtra("telephone", list[position]?.telephone)
            intent.putExtra("email", list[position]?.email)
            intent.putExtra("collectorAlbums", Gson().toJson(list[position]?.collectorAlbums))
            this.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
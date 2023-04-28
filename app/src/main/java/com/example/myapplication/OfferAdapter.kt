package com.example.mobileapp

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Offer
import com.example.myapplication.R
import com.squareup.picasso.Picasso

class OfferAdapter (val offres: ArrayList<Offer>): RecyclerView.Adapter<OfferAdapter.ViewHolder>() {

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){

        val textViewNom = view.findViewById<TextView>(R.id.textviewNomOffre)
        val textViewDesc = view.findViewById<TextView>(R.id.textviewDescriptionOffre)
        val imgViewImg = view.findViewById<ImageView>(R.id.imageviewOffre)
        val layoutContent= view.findViewById<LinearLayout>(R.id.layoutcontentOffre)

        init {
            textViewDesc.maxLines = 2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_offer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val offre = offres.get(position)
        holder.textViewNom.text=offre.name
        holder.textViewDesc.text=offre.description
        Picasso.get().load(offre.picture_url).into(holder.imgViewImg)
    }

    override fun getItemCount(): Int {
        return offres.size
    }
}
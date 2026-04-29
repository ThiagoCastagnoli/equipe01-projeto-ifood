package com.example.equipe01_projeto_ifood.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.equipe01_projeto_ifood.R
import com.example.equipe01_projeto_ifood.model.Lojas
import com.example.equipe01_projeto_ifood.view.DetalhesRestaurantesActivity

class AdapterListRestaurants( private val lista: List<Lojas> ):
        RecyclerView.Adapter<AdapterListRestaurants.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val nomeLoja = view.findViewById<TextView>(R.id.txtNomeLoja)
        val avalaicao = view.findViewById<TextView>(R.id.txtAvaliacaoLoja)
        val taxa = view.findViewById<TextView>(R.id.txtEntregaloja)
        val icon = view.findViewById<ImageView>(R.id.imgLogoLoja)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_loja, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val item = lista[position]
        holder.nomeLoja.text = item.titulo
        holder.avalaicao.text = item.avaliacao
        holder.taxa.text = item.taxa
        holder.icon.setImageResource(item.icon)
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intet = Intent(context, DetalhesRestaurantesActivity::class.java)
            context.startActivity(intet)
        }
    }

    override fun getItemCount() = lista.size



}
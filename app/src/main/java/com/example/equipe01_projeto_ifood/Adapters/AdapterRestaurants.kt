package com.example.equipe01_projeto_ifood.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.equipe01_projeto_ifood.model.Categorias
import com.example.equipe01_projeto_ifood.R

class AdapterRestaurants(private val lista: List<Categorias>) :
    RecyclerView.Adapter<AdapterRestaurants.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nome = view.findViewById<TextView>(R.id.textoRestaurant)
        val icon = view.findViewById<ImageView>(R.id.iconRestaurant)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurantes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lista[position]
        holder.nome.text = item.nome
        holder.icon.setImageResource(item.icon)

    }

    override fun getItemCount() = lista.size
}
package com.example.boaviagem

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.boaviagem.domain.Viagem

class ViagemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(viagem: Viagem) {
        itemView.findViewById<TextView>(R.id.cidade).text = viagem.destino
        itemView.findViewById<TextView>(R.id.data).text = viagem.dataIda.toString().plus(" ").plus(viagem.dataVolta.toString())
        itemView.findViewById<TextView>(R.id.gasto).text = viagem.orcamento.toString()
    }

}

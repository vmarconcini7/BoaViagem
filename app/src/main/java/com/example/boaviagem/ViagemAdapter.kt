package com.example.boaviagem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.boaviagem.domain.Viagem

class ViagemAdapter(val dataset : List<Viagem>) : RecyclerView.Adapter<ViagemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViagemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_viagem, parent, false)
        return ViagemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViagemViewHolder, position: Int) {
        holder.bind(dataset.get(position))
    }

}
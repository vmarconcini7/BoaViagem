package com.example.boaviagem

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.boaviagem.dao.dbViagem
import com.example.boaviagem.domain.Viagem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 *
 */
class MinhasViagens : androidx.fragment.app.Fragment() {

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val layout = inflater.inflate(R.layout.minhas_viagens, container, false)
        val lista = layout.findViewById<RecyclerView>(R.id.listaViagem)
        lateinit var adapter: ViagemAdapter

        GlobalScope.launch(Dispatchers.Main) {

            this@MinhasViagens.context?.also {
                val viagens = dbViagem.getInstance(it).viagemDao().findAll()
                adapter = ViagemAdapter(viagens)
                lista.adapter = adapter
                lista.adapter = ViagemAdapter(viagens)
                lista.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            }
        }
        return layout
    }

}
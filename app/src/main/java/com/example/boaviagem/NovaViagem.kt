package com.example.boaviagem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
class NovaViagem : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nova_viagem, container, false)

        val dtPartida: Button  = findViewById(R.id.dtPartida);
        val dtVolta: Button  = findViewById(R.id.dtVolta);
        val btnSalvar: Button = findViewById(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            salvar()
        }

        dtPartida.setOnClickListener {
            showDatePickerDialog()
        }

        dtVolta.setOnClickListener {
            showDatePickerDialog()
        }
    }

    fun salvar() {
        GlobalScope.launch(Dispatchers.Main) {
            val contatos = withContext(Dispatchers.IO) {
                this@NovaViagem.context?.also {
                    val viagemDao = dbViagem.getInstance(it).viagemDao()
                    val viagem = Viagem("xxxx", "xxxx", "xxxxx", "xxx", 10F, 1)
                    viagemDao.inserir(viagem)
                }
            }
        }
    }

    fun showDatePickerDialog() {
        val newFragment = DatePickerFragment()
        newFragment.show(fragmentManager, "datePicker")
    }
}
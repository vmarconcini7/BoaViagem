package com.example.boaviagem

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
class NovaViagem : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nova_viagem, container, false)
    }

    fun showDatePickerDialog(v: View) {
        val newFragment = DatePickerFragment()
        newFragment.show(fragmentManager, "datePicker")
    }

    fun salvar(v: View) {
        GlobalScope.launch(Dispatchers.Main) {
            val contatos = withContext(Dispatchers.IO) {
                val viagemDao = dbViagem.getInstance(this@NovaViagem).viagemDao()
                val viagem = Viagem("xxxx", "xxxx", "xxxxx", "xxx", 10F, 1)
                viagemDao.inserir(viagem)
            }
        }
    }
}
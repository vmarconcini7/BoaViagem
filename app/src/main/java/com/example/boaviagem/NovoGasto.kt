package com.example.boaviagem

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.boaviagem.dao.dbGasto
import com.example.boaviagem.domain.Gasto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import android.text.Editable
import android.util.Log

/**
 * A simple [Fragment] subclass.
 *
 */
class NovoGasto : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        val layout = inflater.inflate(R.layout.novo_gasto, container, false)

        val dtGasto = layout.findViewById<Button>(R.id.dtGasto)
        val btnSalvar = layout.findViewById<Button>(R.id.btnSalvar)
        val tipoGasto = layout.findViewById<Spinner>(R.id.tipoGasto)
        val dsGasto = layout.findViewById<EditText>(R.id.dsGasto)
        val dsLocal = layout.findViewById<EditText>(R.id.dsLocal)
        
        fun updateDateInView() {

            val myFormat = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            dtGasto.text = Editable.Factory.getInstance().newEditable(sdf.format(cal.time))
        }
        
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }
        
        dtGasto.setOnClickListener {
            DatePickerDialog(this@NovoGasto.context,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()

        }

        btnSalvar.setOnClickListener {
            salvar(tipoGasto.text, dtGasto.text, dsGasto.text, dsLocal.text)
        }
    }

    fun salvar(tipo: String,
               dataGasto: String,
               descricao: String,
               local: String) {
        GlobalScope.launch(Dispatchers.Main) {
            val contatos = withContext(Dispatchers.IO) {
                this@NovoGasto.context?.also {
                    val gastoDao = dbGasto.getInstance(it).gastoDao()
                    val gasto = Gasto(tipo, dataGasto, descricao, local)
                    gastoDao.inserir(gasto)
                }
            }
        }
    }
}

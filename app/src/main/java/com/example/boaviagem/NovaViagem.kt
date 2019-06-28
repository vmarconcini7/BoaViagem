package com.example.boaviagem

import android.app.DatePickerDialog
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
import java.text.SimpleDateFormat
import android.text.Editable
import android.util.Log

/**
 * A simple [Fragment] subclass.
 *
 */
class NovaViagem : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        val layout = inflater.inflate(R.layout.nova_viagem, container, false)

        val dtPartida = layout.findViewById<Button>(R.id.dtPartida)
        val dtVolta = layout.findViewById<Button>(R.id.dtVolta)
        val btnSalvar = layout.findViewById<Button>(R.id.btnSalvar)
        val dsDestino = layout.findViewById<Spinner>(R.id.dsDestino)
        var controlFieldDate = "1";
        
        fun updateDateInView() {

            val myFormat = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            if(controlFieldDate.equals("1")) {
                dtPartida.text = Editable.Factory.getInstance().newEditable(sdf.format(cal.time))
            }else{
                dtVolta.text = Editable.Factory.getInstance().newEditable(sdf.format(cal.time))
            }
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
        
        dtPartida.setOnClickListener {
            controlFieldDate = "1";
            DatePickerDialog(this@NovaViagem.context,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()

        }
        
        dtVolta.setOnClickListener {
            controlFieldDate = "2";
            DatePickerDialog(this@NovaViagem.context,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()

        }

        btnSalvar.setOnClickListener {
            salvar()
        }
    }

    fun salvar(destino: String,
               dataIda: String,
               dataVolta: String,
               tipoViagem: String,
               orcamento: Int,
               qtPessoas: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            val contatos = withContext(Dispatchers.IO) {
                this@NovaViagem.context?.also {
                    val viagemDao = dbViagem.getInstance(it).viagemDao()
                    val viagem = Viagem(destino, dataIda, dataVolta, tipoViagem, orcamento, qtPessoas)
                    viagemDao.inserir(viagem)
                }
            }
        }
    }
}

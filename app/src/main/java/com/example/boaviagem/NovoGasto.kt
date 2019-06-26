package com.example.boaviagem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class NovoGasto : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.novo_gasto, container, false)
    }

}
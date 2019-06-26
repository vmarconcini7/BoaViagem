package com.example.boaviagem

import android.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager
            .beginTransaction()
            .add(R.id.framePrincipal, NovaViagem())
            .commit()

        findViewById<BottomNavigationView>(R.id.navegacao)
            .setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.itemA -> createFragment(NovaViagem())
                    R.id.itemB -> createFragment(NovoGasto())
                    R.id.itemC -> createFragment(MinhasViagens())
                    R.id.itemD -> createFragment(Configuracoes())
                    else -> false
                }
            }

    }

    private fun createFragment(f: androidx.fragment.app.Fragment): Boolean {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framePrincipal, f)
            .addToBackStack(null)
            .commit()
        return true
    }
}
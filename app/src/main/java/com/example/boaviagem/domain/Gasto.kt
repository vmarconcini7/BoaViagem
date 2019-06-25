
package com.example.boaviagem.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Gasto(val tipo: String,
                 val dataGasto: String,
                 val descricao: String,
                 val local: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}
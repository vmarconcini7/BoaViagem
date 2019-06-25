
package com.example.boaviagem.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Viagem(val destino: String,
                  val dataIda: String,
                  val dataVolta: String,
                  val tipoViagem: String,
                  val orcamento: Float,
                  val qtPessoas: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}
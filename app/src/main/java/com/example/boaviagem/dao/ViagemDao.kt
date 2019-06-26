package com.example.teste.dao

import androidx.room.*
import com.example.boaviagem.domain.Viagem

@Dao
interface ViagemDao {

    @Insert
    fun inserir(contato: Viagem)

    @Insert
    fun inserir(contatos: List<Viagem>)

    @Update
    fun update(contato: Viagem)

    @Delete
    fun delete(contato: Viagem)

    @Query("select * from Viagem order by dataIda")
    fun findAll(): List<Viagem>

    @Query("select * from Viagem where id=:id")
    fun findById(id: Int): Viagem




}
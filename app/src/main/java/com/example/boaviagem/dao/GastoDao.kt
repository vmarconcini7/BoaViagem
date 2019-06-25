package com.example.teste.dao

import androidx.room.*
import com.example.boaviagem.domain.Gasto

@Dao
interface GastoDao {

    @Insert
    fun inserir(contato: Gasto)

    @Insert
    fun inserir(contatos: List<Gasto>)

    @Update
    fun update(contato: Gasto)

    @Delete
    fun delete(contato: Gasto)

    @Query("select * from Gasto order by dataGasto")
    fun findAll(): List<Gasto>

    @Query("select * from Gasto where id=:id")
    fun findById(id: Int): Gasto




}
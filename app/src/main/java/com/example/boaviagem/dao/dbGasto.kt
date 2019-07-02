package com.example.boaviagem.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.boaviagem.domain.Gasto
import com.example.teste.dao.GastoDao

@Database(entities = arrayOf(Gasto::class), exportSchema = true, version = 2)
abstract class dbGasto() : RoomDatabase(){

    abstract fun gastoDao(): GastoDao

    companion object {

        private var instance: com.example.boaviagem.dao.dbGasto? = null

        fun getInstance(context: Context): com.example.boaviagem.dao.dbGasto {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    com.example.boaviagem.dao.dbGasto::class.java,
                    "dadosGasto"
                )
                    .build()
            }
            return instance as com.example.boaviagem.dao.dbGasto
        }

    }

}
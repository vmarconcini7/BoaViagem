package com.example.boaviagem.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.boaviagem.NovaViagem
import com.example.boaviagem.domain.Viagem
import com.example.teste.dao.ViagemDao

@Database(entities = arrayOf(Viagem::class), exportSchema = true, version = 2)
abstract class dbViagem() : RoomDatabase(){

    abstract fun viagemDao(): ViagemDao

    companion object {

        private var instance: com.example.boaviagem.dao.dbViagem? = null


        fun getInstance(context: Context): com.example.boaviagem.dao.dbViagem {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    com.example.boaviagem.dao.dbViagem::class.java,
                    "dados"
                )
                    .build()
            }
            return instance as com.example.boaviagem.dao.dbViagem
        }

    }

}
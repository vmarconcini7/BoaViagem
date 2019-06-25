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

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

                database.execSQL("alter table viagem add column destino text not null default ''")
                database.execSQL("alter table viagem add column dataIda text not null default ''")
                database.execSQL("alter table viagem add column dataVolta text not null default ''")
                database.execSQL("alter table viagem add column tipoViagem text not null default ''")
                database.execSQL("alter table viagem add column orcamento number not null default ''")
                database.execSQL("alter table viagem add column qtPessoas number not null default ''")
            }

        }

        fun getInstance(context: NovaViagem): com.example.boaviagem.dao.dbViagem {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    com.example.boaviagem.dao.dbViagem::class.java,
                    "dados"
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()
            }
            return instance as com.example.boaviagem.dao.dbViagem
        }

    }

}
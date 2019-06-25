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

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table gasto add column tipo text not null default ''")
                database.execSQL("alter table gasto add column dataGasto text not null default ''")
                database.execSQL("alter table gasto add column descricao text not null default ''")
                database.execSQL("alter table gasto add column local text not null default ''")
            }

        }

        fun getInstance(context: Context): com.example.boaviagem.dao.dbGasto {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    com.example.boaviagem.dao.dbGasto::class.java,
                    "dados"
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()
            }
            return instance as com.example.boaviagem.dao.dbGasto
        }

    }

}
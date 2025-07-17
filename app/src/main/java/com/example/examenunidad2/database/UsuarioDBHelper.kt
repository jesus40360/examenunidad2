package com.example.examenunidad2.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UsuarioDBHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {

    companion object {
        const val DATABASE_NAME = "usuarios.db"
        const val DATABASE_VERSION = 1

        const val TABLA = "Usuarios"
        const val COL_ID = "id"
        const val COL_NOMBRE = "nombreUsuario"
        const val COL_CORREO = "correo"
        const val COL_CONTRASENA = "contraseña"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val sql = "CREATE TABLE $TABLA (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL_NOMBRE TEXT, " +
                "$COL_CORREO TEXT, " +
                "$COL_CONTRASENA TEXT)"
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA")
        onCreate(db)
    }
}

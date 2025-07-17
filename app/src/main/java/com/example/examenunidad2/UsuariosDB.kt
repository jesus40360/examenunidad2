package com.example.examenunidad2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.examenunidad2.database.UsuarioDBHelper

class UsuariosDB(context: Context) {

    private val helper = UsuarioDBHelper(context)

    fun insert(usuario: Usuarios): Boolean {
        val db = helper.writableDatabase
        val values = ContentValues().apply {
            put(UsuarioDBHelper.COL_NOMBRE, usuario.nombre)
            put(UsuarioDBHelper.COL_CORREO, usuario.correo)
            put(UsuarioDBHelper.COL_CONTRASENA, usuario.contraseña)
        }
        val result = db.insert(UsuarioDBHelper.TABLA, null, values)
        db.close()
        return result != -1L
    }

    fun allUsuarios(): ArrayList<Usuarios> {
        val lista = ArrayList<Usuarios>()
        val db = helper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${UsuarioDBHelper.TABLA}", null)
        if (cursor.moveToFirst()) {
            do {
                lista.add(readUsuario(cursor))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lista
    }

    private fun readUsuario(cursor: Cursor): Usuarios {
        return Usuarios(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getString(3)
        )
    }
}

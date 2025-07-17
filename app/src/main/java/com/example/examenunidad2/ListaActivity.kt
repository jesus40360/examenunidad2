package com.example.examenunidad2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ListaActivity : AppCompatActivity() {

    private lateinit var list: ListView
    private lateinit var btnRegresar: Button
    private lateinit var db: UsuariosDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        list = findViewById(R.id.listView)
        btnRegresar = findViewById(R.id.btnRegresar)
        db = UsuariosDB(this)

        val usuarios = db.allUsuarios()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, usuarios.map { it.nombre })
        list.adapter = adapter

        btnRegresar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}

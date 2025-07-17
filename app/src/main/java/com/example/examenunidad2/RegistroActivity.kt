package com.example.examenunidad2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {

    private lateinit var nombre: EditText
    private lateinit var correo: EditText
    private lateinit var contraseña: EditText
    private lateinit var recontraseña: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnRegistrar: Button
    private lateinit var db: UsuariosDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        nombre = findViewById(R.id.txtNombre)
        correo = findViewById(R.id.txtCorreo)
        contraseña = findViewById(R.id.txtContrasena)
        recontraseña = findViewById(R.id.txtRepetir)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        db = UsuariosDB(this)

        btnRegistrar.setOnClickListener {
            registrar()
        }

        btnIngresar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun registrar() {
        val nombreTxt = nombre.text.toString()
        val correoTxt = correo.text.toString()
        val contraTxt = contraseña.text.toString()
        val repetirTxt = recontraseña.text.toString()

        if (contraTxt != repetirTxt) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

        val usuario = Usuarios(0, nombreTxt, correoTxt, contraTxt)
        db.insert(usuario)
        Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
    }
}

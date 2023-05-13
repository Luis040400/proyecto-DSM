package com.example.proyectodsm.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.proyectodsm.MainActivity
import com.example.proyectodsm.R
import com.example.proyectodsm.alumno.ActivityExamen

class LoginPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_principal)
        val btnAlumno = findViewById<Button>(R.id.btnSesionAlumno)
        val btnMaestro = findViewById<Button>(R.id.btnSesionMaestro)

        btnAlumno.setOnClickListener {
            val intent = Intent(this, ActivityExamen::class.java)
            startActivity(intent)
            finish()
        }

        btnMaestro.setOnClickListener {
            val intent: Intent = Intent(this, LoginMaestro::class.java)
            startActivity(intent)
            finish()
        }
    }
}
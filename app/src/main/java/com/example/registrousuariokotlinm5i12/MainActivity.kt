package com.example.registrousuariokotlinm5i12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int, val correo: String, val sistemaSalud: String)

fun solicitarDatosUsuarios(): List<Usuario> {
    val usuarios = mutableListOf<Usuario>()

    println("Ingrese la cantidad de usuarios a registrar:")
    val cantidad = readLine()?.toIntOrNull() ?: 0

    for (i in 1..cantidad) {
        println("Usuario $i:")
        println("Nombre:")
        val nombre = readLine()?.take(20) ?: ""
        println("Apellido:")
        val apellido = readLine()?.filter { it.isLetter() } ?: ""
        println("Edad:")
        val edad = readLine()?.toIntOrNull() ?: 0
        println("Correo:")
        val correo = readLine()?.trim() ?: ""
        println("Sistema de Salud (Fonasa/Isapre/particular):")
        val sistemaSalud = leerSistemaSalud()

        val usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }

    return usuarios.sortedBy { it.edad }
}

fun leerSistemaSalud(): String {
    val opcionesValidas = listOf("Fonasa", "Isapre", "particular")
    var sistemaSalud: String?

    do {
        sistemaSalud = readLine()?.trim()?.toLowerCase()
    } while (sistemaSalud in opcionesValidas)

    return sistemaSalud ?: ""
}

fun main() {
    val usuarios = solicitarDatosUsuarios()

    println("Usuarios registrados:")
    usuarios.forEach {
        println("Nombre: ${it.nombre} ${it.apellido}, Edad: ${it.edad}, Correo: ${it.correo}, Sistema de Salud: ${it.sistemaSalud}")
    }
}

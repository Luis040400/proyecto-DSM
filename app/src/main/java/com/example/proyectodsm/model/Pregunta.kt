package com.example.proyectodsm.model

data class Pregunta(
    val idPregunta: String?,
    val oA: String?,
    val oB: String?,
    val oC: String?,
    val oD: String?,
    val pregunta: String?,
    val respuesta: String?,
    val tipo: String?
) : java.io.Serializable
package org.example.echo.entities

import kotlinx.serialization.Serializable
import org.example.echo.entities.body.Body

@Serializable
data class Message(
    val src: String,
    val dest: String,
    val body: Body,
)

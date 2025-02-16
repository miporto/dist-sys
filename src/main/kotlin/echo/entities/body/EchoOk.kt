package org.example.echo.entities.body

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("echo_ok")
data class EchoOk(
    override val messageType: String = "echo_ok",
    override val msgId: Int,
    val echo: String,
    val inReplyTo: Int
): Body()

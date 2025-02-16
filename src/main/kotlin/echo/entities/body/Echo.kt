package org.example.echo.entities.body

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("echo")
data class Echo(
    override val messageType: String = "echo",
    override val msgId: Int,
    val echo: String
) : Body()

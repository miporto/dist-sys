package org.example.echo.entities.body

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("init_ok")
data class InitOk(
    override val messageType: String = "init_ok",
    val inReplyTo: Int
) : Body()

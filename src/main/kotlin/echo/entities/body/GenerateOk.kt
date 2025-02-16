package org.example.echo.entities.body

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("generate_ok")
data class GenerateOk(
    override val messageType: String = "generate_ok",
    override val msgId: Int,
    val inReplyTo: Int,
    val id: String
): Body()

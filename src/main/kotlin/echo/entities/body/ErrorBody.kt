package org.example.echo.entities.body

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("error")
data class ErrorBody(
    override val messageType: String = "error",
    override val msgId: Int,
    val code: Int,
    val text: String,
    val inReplyTo: Int
): Body()

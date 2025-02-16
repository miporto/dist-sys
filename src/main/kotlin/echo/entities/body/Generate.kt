package org.example.echo.entities.body

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("generate")
data class Generate(
    override val messageType: String = "generate",
    override val msgId: Int,
): Body()

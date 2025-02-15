package org.example.echo.entities.body

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("init")
data class Init(
    override val messageType: String = "init",
    val msgId: Int,
    val nodeId: String,
    val nodeIds: List<String>
) : Body()

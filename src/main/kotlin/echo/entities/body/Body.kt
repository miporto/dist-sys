package org.example.echo.entities.body

import kotlinx.serialization.Serializable

@Serializable
sealed class Body {
    abstract val messageType: String
    abstract val msgId: Int
}

package org.example.echo

import org.example.echo.entities.Message
import org.example.echo.entities.body.Body

class Node(
    var id: String,
    var msgId: Int,
    var nodesIds: List<String>
) {
    fun reply(message: Message, body: Body): Message {
        return message.copy(
            src = message.dest,
            dest = message.src,
            body = body
        )
    }
}
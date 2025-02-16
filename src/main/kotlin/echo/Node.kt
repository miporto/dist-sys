package org.example.echo

import org.example.echo.entities.Message
import org.example.echo.entities.body.*

class Node(
    private val id: String,
    private var msgId: Int,
    var nodesIds: List<String>
) {

    private fun incrementMessageId() {
        msgId += 1
    }

    private fun buildResponseMessage(message: Message, responseBody: Body): Message {
        return message.copy(
            src = id,
            dest = message.src,
            body = responseBody
        )
    }

    fun reply(message: Message, body: Init): Message {
        incrementMessageId()
        val responseBody = InitOk(msgId = msgId, inReplyTo = body.msgId)
        return buildResponseMessage(message, responseBody)
    }

    fun reply(message: Message, body: Echo): Message {
        incrementMessageId()
        val responseBody = EchoOk(msgId = msgId, inReplyTo = body.msgId, echo = body.echo)
        return buildResponseMessage(message, responseBody)
    }

    fun reply(message: Message, body: Generate): Message {
        incrementMessageId()
        val responseBody = GenerateOk(msgId = msgId, inReplyTo = body.msgId, id = "${id}-$msgId")
        return buildResponseMessage(message, responseBody)
    }

    fun replyError(message: Message): Message {
        incrementMessageId()
        val responseBody = ErrorBody(msgId = msgId, code = 10, text = "Operation not supported", inReplyTo = message.body.msgId)
        return message.copy(
            src = id,
            dest = message.src,
            body = responseBody
        )
    }
}
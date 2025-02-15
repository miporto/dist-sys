package org.example

import org.example.echo.Node
import org.example.echo.Serializer
import org.example.echo.entities.Message
import org.example.echo.entities.body.Init
import org.example.echo.entities.body.InitOk


fun main() {
    val json = Serializer().json
    generateSequence(::readLine).takeWhile { it.isNotEmpty() }.forEach {
        val msg = json.decodeFromString<Message>(it)
        val body = msg.body as Init
        System.err.println("Received: ${json.encodeToString(msg)}")
        val node = Node(body.nodeId, body.msgId, body.nodeIds)
        val responseBody = InitOk(inReplyTo = body.msgId)
        val response = node.reply(msg, responseBody)
        println(json.encodeToString(response))
    }
}

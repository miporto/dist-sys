package org.example.echo

import kotlinx.serialization.json.Json
import org.example.echo.entities.Message
import org.example.echo.entities.body.*

class Server(
    private val json: Json
) {
    private lateinit var node: Node

    fun start() {
        generateSequence(::readLine).takeWhile { it.isNotEmpty() }.forEach {
            log("Received: $it.")
            processMessage(it)
        }
    }

    private fun processMessage(rawMessage: String) {
        val msg = json.decodeFromString<Message>(rawMessage)
        when (val body = msg.body) {
            is Init -> initializeNode(msg, body)
            is Echo -> echo(msg, body)
            else -> unsupportedMessage(msg)
        }
    }

    private fun reply(msg: Message) {
        println(json.encodeToString(msg))
    }

    private fun initializeNode(msg: Message, body: Init) {
        node = Node(body.nodeId, body.msgId, body.nodeIds)
        log("Initialized node.")
        reply(node.reply(msg, body))
    }

    private fun echo(msg: Message, body: Echo) {
        log("Received echo message.")
        reply(node.reply(msg, body))
    }

    private fun unsupportedMessage(msg: Message) {
        node.replyError(msg)
    }

    private fun log(message: String) {
        System.err.println(message)
    }
}
package org.example

import org.example.echo.Serializer
import org.example.echo.Server


fun main() {
    val json = Serializer().json
    val server = Server(json)
    server.start()
}

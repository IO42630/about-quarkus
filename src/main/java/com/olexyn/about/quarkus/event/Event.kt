package com.olexyn.about.quarkus.event

import org.json.JSONObject
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.time.Instant

class Event {
    var timestamp: Instant? = null

    fun fire(): Event {
        timestamp = Instant.now()
        return this
    }

    fun toJson(): String {
        val json = JSONObject()
        json.put("time", timestamp)
        return json.toString()
    }

    @Throws(IOException::class)
    fun persist(): Event {
        Files.write(Path.of("/tmp/event-$timestamp.json"), toJson().toByteArray())
        return this
    }

}

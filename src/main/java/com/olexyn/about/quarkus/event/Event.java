package com.olexyn.about.quarkus.event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.time.Instant;

import org.json.JSONObject;

public class Event {

	Instant timestamp;

	public Event fire() {
		timestamp = Instant.now();
		return this;
	}

	public String toJson() {
		JSONObject json = new JSONObject();
		json.put("time", timestamp);
		return json.toString();
	}

	public Event persist() throws IOException {

		Files.write(Path.of("/tmp/event-"+ timestamp + ".json"), toJson().getBytes());
		return this;
	}

}

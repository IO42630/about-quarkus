package com.olexyn.about.quarkus.event;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class EventTest {

	@Test
	void simpleTest() throws IOException {

		Event event = new Event();
		event.fire().persist();

	}

}

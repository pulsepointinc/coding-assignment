package com.pulsepoint.drawing.canvas

import com.pulsepoint.drawing.command.CommandParser
import com.pulsepoint.drawing.command.result.OkResult
import org.junit.jupiter.api.Assertions

import static org.junit.jupiter.api.Assertions.assertEquals

/**
 * The base class for all integration tests
 */
abstract class CanvasUnderTest {

	def canvas = new ConsoleCanvas()
	CanvasManager manager = new CanvasManager(canvas)
	CommandParser parser = new CommandParser()

	void command(String c) {
		command(c, OkResult.class)
	}

	void command(String command, Class resultType) {
		def result = manager.applyCommand(parser.parseCommand(command))
		Assertions.assertInstanceOf(resultType, result)
	}

	void verifyCommand(String command, String expectedCanvasPicture) {
		this.command(command)
		assertCurrentCanvasPicture(canvas, expectedCanvasPicture)
	}

	void assertCurrentCanvasPicture(String expectedCanvasPicture) {
		assertCurrentCanvasPicture(canvas, expectedCanvasPicture)
	}

	static void assertCurrentCanvasPicture(ConsoleCanvas canvas, String expected) {
		Writer writer = new StringWriter()
		canvas.show(writer)
		println(writer.getBuffer().toString())
		assertEquals(System.lineSeparator() + expected.trim(), System.lineSeparator() + writer.getBuffer().toString().trim())
	}
}

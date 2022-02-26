package com.pulsepoint.drawing.canvas

import com.pulsepoint.drawing.primitive.Pixel
import org.junit.jupiter.api.Test

import static com.pulsepoint.drawing.canvas.CanvasUnderTest.assertCurrentCanvasPicture
import static org.junit.jupiter.api.Assertions.assertFalse
import static org.junit.jupiter.api.Assertions.assertThrows

class ConsoleCanvasTest {

	@Test
	void "canvas should draw and redraw a pixel with different colours"() {
		def canvas = new ConsoleCanvas()
		assertThrows(
				IllegalStateException.class,
				{ canvas.drawPixel(new Pixel(0, 0, 'a' as char)) })

		canvas.init(3, 2)
		canvas.drawPixel(new Pixel(0, 0, 'x' as char))
		assertCurrentCanvasPicture(canvas, """
-----
|x  |
|   |
-----
""")
		canvas.drawPixel(new Pixel(0, 0, 'c' as char))
		assertCurrentCanvasPicture(canvas, """
-----
|c  |
|   |
-----
""")

		assertFalse(canvas.drawPixel(new Pixel(0, 2, 'x' as char)))
		assertFalse(canvas.drawPixel(new Pixel(0, 3, 'x' as char)))
		assertFalse(canvas.drawPixel(new Pixel(3, 0, 'x' as char)))
		assertFalse(canvas.drawPixel(new Pixel(5, 0, 'x' as char)))
	}
}


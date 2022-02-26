package com.pulsepoint.drawing.canvas


import org.junit.jupiter.api.Test

class StatementOfWorkTest extends CanvasUnderTest {

	@Test
	void "should draw example from Statement of work (Issue #1)"() throws Exception {
		command("C 20 4")
		assertCurrentCanvasPicture(canvas,
				"""
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------
""")

		command("l 0 2 19 2")
		assertCurrentCanvasPicture(canvas,
				"""
----------------------
|                    |
|                    |
|xxxxxxxxxxxxxxxxxxxx|
|                    |
----------------------
""")

		command("b 0 0 a")
		assertCurrentCanvasPicture(canvas,
				"""
----------------------
|aaaaaaaaaaaaaaaaaaaa|
|aaaaaaaaaaaaaaaaaaaa|
|xxxxxxxxxxxxxxxxxxxx|
|                    |
----------------------
""")

		command("Q")
		assertCurrentCanvasPicture(canvas,
				"""
----------------------
|aaaaaaaaaaaaaaaaaaaa|
|aaaaaaaaaaaaaaaaaaaa|
|xxxxxxxxxxxxxxxxxxxx|
|                    |
----------------------
""")
	}
}


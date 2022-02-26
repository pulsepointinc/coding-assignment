package com.pulsepoint.drawing.canvas;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.pulsepoint.drawing.command.CommandLine;
import com.pulsepoint.drawing.command.result.FailedResult;
import com.pulsepoint.drawing.command.result.OkResult;
import com.pulsepoint.drawing.command.result.PartiallyAppliedResult;
import java.util.ArrayDeque;
import java.util.List;
import org.junit.jupiter.api.Test;

class CanvasManagerTest {

  @Test
  void commandsResultTest() {
    ConsoleCanvas canvas = new ConsoleCanvas();
    CanvasManager manager = new CanvasManager(canvas);
    assertInstanceOf(FailedResult.class, manager.applyCommand(newLine(0, 0)));

    int width = 10;
    int height = 10;
    canvas.init(width, height);
    assertInstanceOf(OkResult.class, manager.applyCommand(newLine(0, 0)));
    assertInstanceOf(
        PartiallyAppliedResult.class, manager.applyCommand(newLine(width * 10, height * 10)));
  }

  private CommandLine newLine(int endX, int endY) {
    return new CommandLine(
        new ArrayDeque<>(List.of("0", "0", String.valueOf(endX), String.valueOf(endY))));
  }
}

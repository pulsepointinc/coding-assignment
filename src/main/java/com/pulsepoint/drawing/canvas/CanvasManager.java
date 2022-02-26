package com.pulsepoint.drawing.canvas;

import com.pulsepoint.drawing.command.Command;
import com.pulsepoint.drawing.command.result.CommandResult;
import com.pulsepoint.drawing.command.result.FailedResult;
import com.pulsepoint.drawing.command.result.OkResult;
import com.pulsepoint.drawing.command.result.PartiallyAppliedResult;
import com.pulsepoint.drawing.primitive.Pixel;
import java.io.IOException;
import java.io.Writer;

/** Manager to rule canvas, apply some commands on it and show on display the results */
public class CanvasManager {

  private final Canvas canvas;

  public CanvasManager(Canvas canvas) {
    this.canvas = canvas;
  }

  /**
   * Apply command on the canvas
   *
   * @return command result with some information about apply process
   */
  public CommandResult applyCommand(Command command) {

    try {
      for (Pixel pixel : command.draw(canvas)) {
        if (!canvas.drawPixel(pixel)) {
          return new PartiallyAppliedResult(command);
        }
      }
      return new OkResult(command);
    } catch (Exception e) {
      return new FailedResult(command, e);
    }
  }

  public void show(Writer writer) throws IOException {
    canvas.show(writer);
  }
}

package com.pulsepoint.drawing.command;

import com.pulsepoint.drawing.canvas.Canvas;
import com.pulsepoint.drawing.primitive.Shape;

/** Common interface for various of commands */
public interface Command {

  /**
   * Draw something using {@link Canvas} interface
   *
   * @return a shape as an iterator of pixes drawn by this command
   */
  Shape draw(Canvas canvas);
}

package com.pulsepoint.drawing.command;

import com.pulsepoint.drawing.canvas.Canvas;
import com.pulsepoint.drawing.primitive.Shape;
import java.util.Collections;

public class NopCommand implements Command {

  @Override
  public Shape draw(Canvas canvas) {
    // do nothing
    return new Shape(Collections::emptyIterator);
  }
}

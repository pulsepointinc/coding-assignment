package com.pulsepoint.drawing.command;

import static java.lang.Integer.parseInt;

import com.pulsepoint.drawing.canvas.Canvas;
import com.pulsepoint.drawing.primitive.Shape;
import java.util.Collections;
import java.util.Deque;
import java.util.NoSuchElementException;
import lombok.Getter;

@Getter
public class CommandNewCanvas implements Command {

  private final int width;
  private final int height;

  public CommandNewCanvas(Deque<String> args) {
    try {
      width = parseInt(args.pop());
      height = parseInt(args.pop());

    } catch (NoSuchElementException | NumberFormatException e) {
      throw new IllegalArgumentException(
          "Arguments for CommandNewCanvas should have width and height which represent as 2 integer values");
    }
  }

  @Override
  public Shape draw(Canvas canvas) {
    canvas.init(width, height);
    return new Shape(Collections::emptyIterator);
  }
}

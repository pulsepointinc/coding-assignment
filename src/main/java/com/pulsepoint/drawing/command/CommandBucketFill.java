package com.pulsepoint.drawing.command;

import static java.lang.Integer.parseInt;

import com.pulsepoint.drawing.algo.FloodFill4;
import com.pulsepoint.drawing.canvas.Canvas;
import com.pulsepoint.drawing.primitive.Colour;
import com.pulsepoint.drawing.primitive.Point;
import com.pulsepoint.drawing.primitive.Shape;
import java.util.Deque;
import java.util.NoSuchElementException;
import lombok.Getter;

@Getter
public class CommandBucketFill implements Command {
  private static final FloodFill4 fillAlgo = new FloodFill4();

  private final Point startPoint;
  private final Colour colour;

  public CommandBucketFill(Deque<String> args) {
    try {
      startPoint = new Point(parseInt(args.pop()), parseInt(args.pop()));
      String colour = args.pop();
      if (colour.length() != 1) {
        throw new IllegalArgumentException("Colour should be represent as single character");
      }
      this.colour = new Colour(colour.toCharArray()[0]);

    } catch (NoSuchElementException | NumberFormatException e) {
      throw new IllegalArgumentException(
          "Arguments for CommandBucketFill should have 4 coordinates which represent as 4 integer values");
    }
  }

  @Override
  public Shape draw(Canvas canvas) {
    return fillAlgo.fill(canvas, startPoint, colour);
  }
}

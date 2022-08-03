package com.pulsepoint.drawing.command;

import com.pulsepoint.drawing.algo.BresenhamAlgo;
import com.pulsepoint.drawing.canvas.Canvas;
import com.pulsepoint.drawing.primitive.Colour;
import com.pulsepoint.drawing.primitive.Point;
import com.pulsepoint.drawing.primitive.Shape;
import java.util.Deque;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.IterableUtils;

public class CommandRectangle implements Command {

  private static final BresenhamAlgo lineAlgo = new BresenhamAlgo();
  public static final Colour RECTANGLE_COLOUR = new Colour('x');

  private final Point leftCorner;
  private final Point rightCorner;

  public CommandRectangle(Deque<String> args) {
    try {
      leftCorner = new Point(Integer.parseInt(args.pop()), Integer.parseInt(args.pop()));
      rightCorner = new Point(Integer.parseInt(args.pop()), Integer.parseInt(args.pop()));

    } catch (NoSuchElementException | NumberFormatException e) {
      throw new IllegalArgumentException(
          "Arguments for CommandRectangle should have 4 coordinates which represent as 4 integer values");
    }
  }

  public Point getLeftCorner() {
    return leftCorner;
  }

  public Point getRightCorner() {
    return rightCorner;
  }

  @Override
  public Shape draw(Canvas canvas) {
    return new Shape(
        IterableUtils.chainedIterable(
            lineAlgo.plotLine(
                leftCorner, new Point(rightCorner.getX(), leftCorner.getY()), RECTANGLE_COLOUR),
            lineAlgo.plotLine(
                leftCorner, new Point(leftCorner.getX(), rightCorner.getY()), RECTANGLE_COLOUR),
            lineAlgo.plotLine(
                new Point(leftCorner.getX(), rightCorner.getY()), rightCorner, RECTANGLE_COLOUR),
            lineAlgo.plotLine(
                new Point(rightCorner.getX(), leftCorner.getY()), rightCorner, RECTANGLE_COLOUR)));
  }
}

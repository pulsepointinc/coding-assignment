package com.pulsepoint.drawing.algo;

import static java.lang.Math.abs;

import com.pulsepoint.drawing.primitive.Colour;
import com.pulsepoint.drawing.primitive.Pixel;
import com.pulsepoint.drawing.primitive.Point;
import com.pulsepoint.drawing.primitive.Shape;
import java.util.Iterator;

/**
 * Bresenham's line algorithm is a line drawing algorithm that determines the points of an
 * n-dimensional raster that should be selected in order to form a close approximation to a straight
 * line between two points.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm">Bresenham's line
 *     algorithm full description</a>
 */
public class BresenhamAlgo {

  /**
   * Plot a line in 2-dimensional raster between {@code start} and {@code end} points
   *
   * @implNote implemented according to <a
   *     href="https://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm#All_cases">the algorithm
   *     pseudo-code</a>
   * @param start point
   * @param end point
   * @param colour of the line
   * @return Shape as a pixel iterator of the line
   */
  public Shape plotLine(Point start, Point end, Colour colour) {
    int x0 = start.getX();
    int y0 = start.getY();
    int x1 = end.getX();
    int y1 = end.getY();

    if (abs(y1 - y0) < abs(x1 - x0)) {
      if (x0 > x1) {
        return plotLineLow(x1, y1, x0, y0, colour);
      } else {
        return plotLineLow(x0, y0, x1, y1, colour);
      }
    } else {
      if (y0 > y1) {
        return plotLineHigh(x1, y1, x0, y0, colour);
      } else {
        return plotLineHigh(x0, y0, x1, y1, colour);
      }
    }
  }

  private Shape plotLineLow(int x0, int y0, int x1, int y1, Colour colour) {
    final int deltaX = x1 - x0;
    final int deltaY = abs(y1 - y0);

    int directionY;
    if (y1 - y0 < 0) {
      directionY = -1;
    } else {
      directionY = 1;
    }

    return new Shape(
        () ->
            new Iterator<Pixel>() {
              int D = (2 * deltaY) - deltaX;
              int currentX = x0;
              int currentY = y0;

              @Override
              public boolean hasNext() {
                return currentX <= x1;
              }

              @Override
              public Pixel next() {
                Pixel result = new Pixel(currentX, currentY, colour);
                if (D > 0) {
                  currentY = currentY + directionY;
                  D = D + (2 * (deltaY - deltaX));
                } else {
                  D = D + 2 * deltaY;
                }

                currentX++;
                return result;
              }
            });
  }

  private Shape plotLineHigh(int x0, int y0, int x1, int y1, Colour colour) {
    final int deltaX = abs(x1 - x0);
    final int deltaY = y1 - y0;

    final int directionX;
    if (x1 - x0 < 0) {
      directionX = -1;
    } else {
      directionX = 1;
    }

    return new Shape(
        () ->
            new Iterator<Pixel>() {
              int D = (2 * deltaX) - deltaY;

              int currentX = x0;
              int currentY = y0;

              @Override
              public boolean hasNext() {
                return currentY <= y1;
              }

              @Override
              public Pixel next() {
                Pixel result = new Pixel(currentX, currentY, colour);

                if (D > 0) {
                  currentX = currentX + directionX;
                  D = D + (2 * (deltaX - deltaY));
                } else {
                  D = D + 2 * deltaX;
                }

                currentY++;
                return result;
              }
            });
  }
}

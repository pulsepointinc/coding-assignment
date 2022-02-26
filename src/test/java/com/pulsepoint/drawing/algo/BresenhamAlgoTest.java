package com.pulsepoint.drawing.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pulsepoint.drawing.primitive.Colour;
import com.pulsepoint.drawing.primitive.Pixel;
import com.pulsepoint.drawing.primitive.Point;
import com.pulsepoint.drawing.primitive.Shape;
import java.util.Arrays;
import java.util.Collections;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;

public class BresenhamAlgoTest {

  private final BresenhamAlgo algo = new BresenhamAlgo();

  @Test
  public void drawLine() {
    Shape line = algo.plotLine(new Point(0, 1), new Point(6, 4), new Colour('x'));

    assertEquals(
        Arrays.asList(
            new Pixel(0, 1, 'x'),
            new Pixel(1, 1, 'x'),
            new Pixel(2, 2, 'x'),
            new Pixel(3, 2, 'x'),
            new Pixel(4, 3, 'x'),
            new Pixel(5, 3, 'x'),
            new Pixel(6, 4, 'x')),
        IterableUtils.toList(line));
  }

  @Test
  public void drawVerticalLine() {
    Shape line = algo.plotLine(new Point(0, 1), new Point(0, 4), new Colour('x'));

    assertEquals(
        Arrays.asList(
            new Pixel(0, 1, 'x'), new Pixel(0, 2, 'x'), new Pixel(0, 3, 'x'), new Pixel(0, 4, 'x')),
        IterableUtils.toList(line));
  }

  @Test
  public void drawHorizontalLine() {
    Shape line = algo.plotLine(new Point(1, 0), new Point(5, 0), new Colour('x'));

    assertEquals(
        Arrays.asList(
            new Pixel(1, 0, 'x'),
            new Pixel(2, 0, 'x'),
            new Pixel(3, 0, 'x'),
            new Pixel(4, 0, 'x'),
            new Pixel(5, 0, 'x')),
        IterableUtils.toList(line));
  }

  @Test
  public void drawDot() {
    Shape line = algo.plotLine(new Point(0, 0), new Point(0, 0), new Colour('x'));

    assertEquals(Collections.singletonList(new Pixel(0, 0, 'x')), IterableUtils.toList(line));
  }

  @Test
  public void drawLineStartToTheLeftEnd() {
    Shape line = algo.plotLine(new Point(6, 4), new Point(0, 1), new Colour('x'));

    assertEquals(
        Arrays.asList(
            new Pixel(0, 1, 'x'),
            new Pixel(1, 1, 'x'),
            new Pixel(2, 2, 'x'),
            new Pixel(3, 2, 'x'),
            new Pixel(4, 3, 'x'),
            new Pixel(5, 3, 'x'),
            new Pixel(6, 4, 'x')),
        IterableUtils.toList(line));
  }

  @Test
  public void drawLineStartUnderEnd() {
    Shape line = algo.plotLine(new Point(0, 4), new Point(4, 0), new Colour('x'));

    assertEquals(
        Arrays.asList(
            new Pixel(4, 0, 'x'),
            new Pixel(3, 1, 'x'),
            new Pixel(2, 2, 'x'),
            new Pixel(1, 3, 'x'),
            new Pixel(0, 4, 'x')),
        IterableUtils.toList(line));
  }

  @Test
  public void drawLineElongatedByY() {
    Shape line = algo.plotLine(new Point(0, 0), new Point(1, 10), new Colour('x'));

    assertEquals(
        Arrays.asList(
            new Pixel(0, 0, 'x'),
            new Pixel(0, 1, 'x'),
            new Pixel(0, 2, 'x'),
            new Pixel(0, 3, 'x'),
            new Pixel(0, 4, 'x'),
            new Pixel(0, 5, 'x'),
            new Pixel(1, 6, 'x'),
            new Pixel(1, 7, 'x'),
            new Pixel(1, 8, 'x'),
            new Pixel(1, 9, 'x'),
            new Pixel(1, 10, 'x')),
        IterableUtils.toList(line));
  }
}

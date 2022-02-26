package com.pulsepoint.drawing.canvas;

import com.pulsepoint.drawing.primitive.Pixel;
import com.pulsepoint.drawing.primitive.Point;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

/** Common interface for a pixel field with abilities to draw pixels and show the result */
public interface Canvas {

  /**
   * Every canvas should be initialized before any attempt to draw something on it
   *
   * @param width of canvas
   * @param height of canvas
   */
  void init(int width, int height);

  /**
   * Draw a pixel on the canvas
   *
   * @return true - if pixel was drawn, false - otherwise
   */
  boolean drawPixel(Pixel pixel) throws Exception;

  /**
   * try to lookup a pixel from the canvas
   *
   * @param point on the canvas
   * @return pixel information if any
   */
  Optional<Pixel> getPixel(Point point);

  /**
   * Print out the canvas
   *
   * @param writer output
   * @throws IOException a standard {@link Writer} exception if some {@link Writer#append} or {@link
   *     Writer#flush} failed
   */
  void show(Writer writer) throws IOException;
}

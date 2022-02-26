package com.pulsepoint.drawing.canvas;

import com.pulsepoint.drawing.primitive.Colour;
import com.pulsepoint.drawing.primitive.Pixel;
import com.pulsepoint.drawing.primitive.Point;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

/** Ascii canvas implementation. */
public class ConsoleCanvas implements Canvas {

  public static final char SIDE_BORDER_CHAR = '|';
  public static final char TOP_BOTTOM_BORDER_CHAR = '-';
  public static final char EMPTY_SPACE_CHAR = ' ';
  private boolean init = false;

  private int width = 0;
  private int height = 0;

  private char[][] matrix;

  @Override
  public void init(int width, int height) {
    this.width = width;
    this.height = height;

    matrix = new char[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        matrix[i][j] = EMPTY_SPACE_CHAR;
      }
    }

    init = true;
  }

  @Override
  public boolean drawPixel(Pixel pixel) {
    if (notInitialized()) {
      throw new IllegalStateException("Canvas is not initialized");
    }
    if (pointOutOfBound(pixel.getPoint())) {
      return false;
    }

    matrix[pixel.getY()][pixel.getX()] = pixel.getColourValue();
    return true;
  }

  @Override
  public Optional<Pixel> getPixel(Point point) {
    if (pointOutOfBound(point)) {
      return Optional.empty();
    }
    return Optional.of(new Pixel(point, new Colour(matrix[point.getY()][point.getX()])));
  }

  @Override
  public void show(Writer writer) throws IOException {
    if (notInitialized()) {
      return;
    }

    for (int i = 0; i < width + 2; i++) {
      writer.append(TOP_BOTTOM_BORDER_CHAR);
    }
    writer.append(System.lineSeparator());

    for (int i = 0; i < height; i++) {
      writer.append(SIDE_BORDER_CHAR);
      for (char c : matrix[i]) {
        writer.append(c);
      }
      writer.append(SIDE_BORDER_CHAR);
      writer.append(System.lineSeparator());
    }

    for (int i = 0; i < width + 2; i++) {
      writer.append(TOP_BOTTOM_BORDER_CHAR);
    }
    writer.append(System.lineSeparator());
    writer.flush();
  }

  private boolean notInitialized() {
    return !init;
  }

  private boolean pointOutOfBound(Point point) {
    return point.getX() < 0 || point.getY() < 0 || point.getX() >= width || point.getY() >= height;
  }
}

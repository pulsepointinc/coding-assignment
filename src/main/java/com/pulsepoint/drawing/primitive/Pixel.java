package com.pulsepoint.drawing.primitive;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Pixel {
  Point point;
  Colour colour;

  public Pixel(int x, int y, char value) {
    this.point = new Point(x, y);
    this.colour = new Colour(value);
  }

  public Pixel(int x, int y, Colour colour) {
    this.point = new Point(x, y);
    this.colour = colour;
  }

  public int getX() {
    return point.getX();
  }

  public int getY() {
    return point.getY();
  }

  public char getColourValue() {
    return colour.getValue();
  }
}

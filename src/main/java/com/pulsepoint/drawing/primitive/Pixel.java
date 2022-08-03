package com.pulsepoint.drawing.primitive;

import java.util.Objects;

public final class Pixel {
  private final Point point;
  private final Colour colour;

  public Pixel(int x, int y, char value) {
    this.point = new Point(x, y);
    this.colour = new Colour(value);
  }

  public Pixel(int x, int y, Colour colour) {
    this.point = new Point(x, y);
    this.colour = colour;
  }

  public Pixel(Point point, Colour colour) {
    this.point = point;
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

  public Point getPoint() {
    return this.point;
  }

  public Colour getColour() {
    return this.colour;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pixel pixel = (Pixel) o;
    return point.equals(pixel.point) && colour.equals(pixel.colour);
  }

  @Override
  public int hashCode() {
    return Objects.hash(point, colour);
  }

  public String toString() {
    return "Pixel(point=" + this.getPoint() + ", colour=" + this.getColour() + ")";
  }
}

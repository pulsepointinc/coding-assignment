package com.pulsepoint.drawing.primitive;

import java.util.Objects;

public final class Colour {
  private final char value;

  public Colour(char value) {
    this.value = value;
  }

  public char getValue() {
    return this.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Colour colour = (Colour) o;
    return value == colour.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  public String toString() {
    return "Colour(value=" + this.getValue() + ")";
  }
}

package com.pulsepoint.drawing.primitive;

import java.util.Iterator;

public final class Shape implements Iterable<Pixel> {

  private final Iterable<Pixel> iterable;

  public Shape(Iterable<Pixel> iterable) {
    this.iterable = iterable;
  }

  @Override
  public Iterator<Pixel> iterator() {
    return iterable.iterator();
  }

  public Iterable<Pixel> getIterable() {
    return this.iterable;
  }

  public String toString() {
    return "Shape(iterable=" + this.getIterable() + ")";
  }
}

package com.pulsepoint.drawing.primitive;

import java.util.Iterator;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Shape implements Iterable<Pixel> {

  Iterable<Pixel> iterable;

  @Override
  public Iterator<Pixel> iterator() {
    return iterable.iterator();
  }
}

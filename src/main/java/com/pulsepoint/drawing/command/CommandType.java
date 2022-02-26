package com.pulsepoint.drawing.command;

import java.util.Deque;
import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CommandType {
  NEW_CANVAS("C", CommandNewCanvas::new),
  LINE("L", CommandLine::new),
  RECTANGLE("R", CommandRectangle::new),
  BUCKET_FILL("B", CommandBucketFill::new),
  QUIT("Q", Quit::new),
  ;

  private final String commandCharacter;
  @Getter private final ArgParser commandArgParser;

  public Optional<CommandType> tryParse(String input) {
    return input.equalsIgnoreCase(commandCharacter) ? Optional.of(this) : Optional.empty();
  }

  @FunctionalInterface
  public interface ArgParser {
    Command parse(Deque<String> args);
  }
}

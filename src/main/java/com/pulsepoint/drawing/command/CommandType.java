package com.pulsepoint.drawing.command;

import java.util.Deque;
import java.util.Optional;

public enum CommandType {
  NEW_CANVAS("C", CommandNewCanvas::new),
  LINE("L", CommandLine::new),
  RECTANGLE("R", CommandRectangle::new),
  BUCKET_FILL("B", CommandBucketFill::new),
  QUIT("Q", Quit::new),
  ;

  private final String commandCharacter;
  private final ArgParser commandArgParser;

  CommandType(String commandCharacter, ArgParser commandArgParser) {
    this.commandCharacter = commandCharacter;
    this.commandArgParser = commandArgParser;
  }

  public Optional<CommandType> tryParse(String input) {
    return input.equalsIgnoreCase(commandCharacter) ? Optional.of(this) : Optional.empty();
  }

  public ArgParser getCommandArgParser() {
    return this.commandArgParser;
  }

  @FunctionalInterface
  public interface ArgParser {
    Command parse(Deque<String> args);
  }
}

package com.pulsepoint.drawing.command;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Optional;
import java.util.stream.Stream;

public class CommandParser {

  public Command parseCommand(String input)
      throws IllegalCommandException, IllegalArgumentException {
    if (input == null) {
      throw new IllegalArgumentException("Command can't be null ");
    }

    String[] split = input.trim().split("\\s");
    Deque<String> tokens = new ArrayDeque<>(Arrays.asList(split));

    String command = tokens.pop();
    CommandType.ArgParser commandArgParser =
        Stream.of(CommandType.values())
            .map(commandType -> commandType.tryParse(command))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(CommandType::getCommandArgParser)
            .findAny()
            .orElseThrow(() -> new IllegalCommandException("Unknown command"));
    return commandArgParser.parse(tokens);
  }
}

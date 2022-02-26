package com.pulsepoint.drawing.command;

import java.util.*;
import java.util.stream.Stream;
import lombok.NonNull;

public class CommandParser {

  public Command parseCommand(@NonNull String input)
      throws IllegalCommandException, IllegalArgumentException {
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

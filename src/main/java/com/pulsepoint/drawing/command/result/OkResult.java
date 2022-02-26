package com.pulsepoint.drawing.command.result;

import com.pulsepoint.drawing.command.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class OkResult extends CommandResult {
  public OkResult(Command command) {
    super(command);
  }

  @Override
  public void printCommandResult(Writer standard, PrintWriter error) throws IOException {
    standard.write(getCommand().getClass().getSimpleName() + " ✓");
  }
}

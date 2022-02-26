package com.pulsepoint.drawing.command.result;

import com.pulsepoint.drawing.command.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class PartiallyAppliedResult extends CommandResult {

  public PartiallyAppliedResult(Command command) {
    super(command);
  }

  @Override
  public void printCommandResult(Writer standard, PrintWriter error) throws IOException {
    standard.write(
        "[WARN] "
            + getCommand().getClass().getSimpleName()
            + " was partially applied (there were some invisible pixels)");
  }
}

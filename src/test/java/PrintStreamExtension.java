import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintStreamExtension implements BeforeEachCallback, AfterEachCallback {

  private final OutputStream out = System.out;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  public String getOutput() {
    return outContent.toString().trim();
  }
  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    System.setOut(new PrintStream(out));
    outContent.reset();
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) throws Exception {
    System.setOut(new PrintStream(outContent));
  }
}

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

  private final OutputStream out = System.out;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @DisplayName("Helloクラスの main() メソッドのテスト")
  @Test
  public void test() {

    var expected = "Hello!";
    Hello.main(null);
    assertEquals(expected, getOutput());
  }

  private String getOutput() {
    return outContent.toString().trim();
  }

  @AfterEach
  public void tearDown() {
    System.setOut(new PrintStream(out));
    outContent.reset();
  }

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outContent));
  }
}

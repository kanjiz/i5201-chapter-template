import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModifiedHelloTest {

  @RegisterExtension
  static PrintStreamExtension printStreamExtension = new PrintStreamExtension();

  @DisplayName("Helloクラスの main() メソッドのテスト")
  @Test
  public void test() {

    var expected = "Hello!";
    Hello.main(null);
    assertEquals(expected, printStreamExtension.getOutput());
  }
}

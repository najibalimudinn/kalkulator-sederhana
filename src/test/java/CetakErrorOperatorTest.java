import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import com.najib.modules.IOHandler;

public class CetakErrorOperatorTest {

    private IOHandler ioHandler;

    @BeforeEach
    public void setUp() {
        ioHandler = new IOHandler(); 
    }

    @Test
    public void testCetakErrorOperator() {
        // 1. Setup
        String expected = "Error: Operator tidak valid.";

        // 2. Exercise
        String actual = ioHandler.cetakErrorOperator();

        // 3. Verify
        assertEquals(expected, actual);
    }
}

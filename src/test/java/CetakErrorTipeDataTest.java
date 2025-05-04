import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import com.najib.modules.IOHandler;

public class CetakErrorTipeDataTest {
    private IOHandler ioHandler;

    @BeforeEach
    public void setUp() {
        ioHandler = new IOHandler(); 
    }

    @Test
    public void testCetakErrorTipeData() {
        // 1. Setup
        String expected = "Error: Input harus berupa angka.";

        // 2. Exercise
        String actual = ioHandler.cetakErrorTipeData();

        // 3. Verify
        assertEquals(expected, actual);
    }   
}

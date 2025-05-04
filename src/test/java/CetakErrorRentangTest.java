import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import com.najib.modules.IOHandler;

public class CetakErrorRentangTest {

    private IOHandler ioHandler;

    @BeforeEach
    public void setUp() {
        ioHandler = new IOHandler();
    }

    @Test
    public void testCetakErrorRentang() {
        // 1. Setup
        String expected = "Error: Nilai di luar rentang yang diperbolehkan.";

        // 2. Exercise
        String actual = ioHandler.cetakErrorRentang();

        // 3. Verify
        assertEquals(expected, actual);
    }
}

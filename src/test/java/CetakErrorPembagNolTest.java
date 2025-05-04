import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import com.najib.modules.IOHandler;

public class CetakErrorPembagNolTest {
    
    private IOHandler ioHandler;

    @BeforeEach
    public void setUp() {
        ioHandler = new IOHandler(); 
    }

    @Test
    public void testCetakErrorPembagiNol() {
        // 1. Setup
        String expected = "Error: Pembagian dengan nol tidak diperbolehkan.";

        // 2. Exercise
        String actual = ioHandler.cetakErrorPembagiNol();

        // 3. Verify
        assertEquals(expected, actual);
    }
}

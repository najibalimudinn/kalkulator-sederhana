import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import com.najib.modules.IOHandler;

public class CetakPesanInputOperatorTest {
    
    private IOHandler ioHandler;

    @BeforeEach
    public void setUp() {
        ioHandler = new IOHandler(); 
    }

    @Test
    public void testCetakPesanInputOperator() {
        // 1. Setup
        String expected = "Masukkan operator (+, -, *, /): ";

        // 2. Exercise
        String actual = ioHandler.cetakPesanInputOperator();

        // 3. Verify
        assertEquals(expected, actual);
    }
}

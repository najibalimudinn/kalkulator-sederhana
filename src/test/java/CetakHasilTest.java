import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import com.najib.modules.IOHandler;

public class CetakHasilTest {
    
    private IOHandler ioHandler;

    @BeforeEach
    public void setUp() {
        ioHandler = new IOHandler(); 
    }

    @Test
    public void testCetakHasil() {
        // 1. Setup
        int hasil = 5;
        String expected = "Hasil = 5";

        // 2. Exercise
        String actual = ioHandler.cetakHasil(hasil);

        // 3. Verify
        assertEquals(expected, actual);
    }
}

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import com.najib.modules.IOHandler;

public class CetakPesanInputNomorTest {

    private IOHandler ioHandler;

    @BeforeEach
    public void setUp() {
        ioHandler = new IOHandler(); 
    }

    @Test
    public void testCetakPesanInputNomor() {
        // 1. Setup
        String expected = "Masukkan dua buah nilai (pisahkan dengan spasi): ";

        // 2. Exercise
        String actual = ioHandler.cetakPesanInputNomor();

        // 3. Verify
        assertEquals(expected, actual);
    }
}
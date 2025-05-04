import com.najib.modules.IOHandler;
import com.najib.modules.IOHandler.*;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class inputNomorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private MockedStatic<IOHandler> mockedStatic;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testInputDenganNomor() {
        //setup
        System.setIn(new ByteArrayInputStream("1 0\n".getBytes()));

        mockedStatic = mockStatic(IOHandler.class);
        mockedStatic.when(IOHandler::inputNomor).thenCallRealMethod();
        mockedStatic.when(IOHandler::cetakPesanInputNomor).thenReturn("Masukkan dua buah nilai (pisahkan dengan spasi): ");

        //exercise
        InputAngka result = IOHandler.inputNomor();

        //verify
        assertEquals("Masukkan dua buah nilai (pisahkan dengan spasi): ", outContent.toString());
        assertEquals("1", result.a());
        assertEquals("0", result.b());
    }

    @Test
    void testInputDenganHuruf() {
        //setup
        System.setIn(new ByteArrayInputStream("o D\n".getBytes()));

        mockedStatic = mockStatic(IOHandler.class);
        mockedStatic.when(IOHandler::inputNomor).thenCallRealMethod();
        mockedStatic.when(IOHandler::cetakPesanInputNomor).thenReturn("Masukkan dua buah nilai (pisahkan dengan spasi): ");

        //exercise
        InputAngka result = IOHandler.inputNomor();

        //verify
        assertEquals("Masukkan dua buah nilai (pisahkan dengan spasi): ", outContent.toString());
        assertEquals("o", result.a());
        assertEquals("D", result.b());
    }

    @Test
    void testInputDenganSimbol() {
        //setup
        System.setIn(new ByteArrayInputStream("! >\n".getBytes()));

        mockedStatic = mockStatic(IOHandler.class);
        mockedStatic.when(IOHandler::inputNomor).thenCallRealMethod();
        mockedStatic.when(IOHandler::cetakPesanInputNomor).thenReturn("Masukkan dua buah nilai (pisahkan dengan spasi): ");

        //exercise
        InputAngka result = IOHandler.inputNomor();

        //verify
        assertEquals("Masukkan dua buah nilai (pisahkan dengan spasi): ", outContent.toString());
        assertEquals("!", result.a());
        assertEquals(">", result.b());
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        mockedStatic.close();
    }
}

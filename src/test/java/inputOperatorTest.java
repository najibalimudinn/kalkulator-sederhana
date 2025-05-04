import com.najib.modules.IOHandler;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class inputOperatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private MockedStatic<IOHandler> mockedStatic;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testInputTambah() {
        //setup
        System.setIn(new ByteArrayInputStream("+\n".getBytes()));

        mockedStatic = mockStatic(IOHandler.class);
        mockedStatic.when(IOHandler::inputOperator).thenCallRealMethod();
        mockedStatic.when(IOHandler::cetakPesanInputOperator).thenReturn("Masukkan operator (+, -, *, /):");

        //exercise
        char result = IOHandler.inputOperator();

        //verify
        assertEquals("Masukkan operator (+, -, *, /):", outContent.toString().trim());
        assertEquals('+', result);
    }

    @Test
    void testInputKurang() {
        //setup
        System.setIn(new ByteArrayInputStream("-\n".getBytes()));

        mockedStatic = mockStatic(IOHandler.class);
        mockedStatic.when(IOHandler::inputOperator).thenCallRealMethod();
        mockedStatic.when(IOHandler::cetakPesanInputOperator).thenReturn("Masukkan operator (+, -, *, /):");

        //exercise
        char result = IOHandler.inputOperator();

        //verify
        assertEquals("Masukkan operator (+, -, *, /):", outContent.toString().trim());
        assertEquals('-', result);
    }

    @Test
    void testInputKali() {
        //setup
        System.setIn(new ByteArrayInputStream("*\n".getBytes()));

        mockedStatic = mockStatic(IOHandler.class);
        mockedStatic.when(IOHandler::inputOperator).thenCallRealMethod();
        mockedStatic.when(IOHandler::cetakPesanInputOperator).thenReturn("Masukkan operator (+, -, *, /):");

        //exercise
        char result = IOHandler.inputOperator();

        //verify
        assertEquals("Masukkan operator (+, -, *, /):", outContent.toString().trim());
        assertEquals('*', result);
    }

    @Test
    void testInputBagi() {
        //setup
        System.setIn(new ByteArrayInputStream("*\n".getBytes()));

        mockedStatic = mockStatic(IOHandler.class);
        mockedStatic.when(IOHandler::inputOperator).thenCallRealMethod();
        mockedStatic.when(IOHandler::cetakPesanInputOperator).thenReturn("Masukkan operator (+, -, *, /):");

        //exercise
        char result = IOHandler.inputOperator();

        //verify
        assertEquals("Masukkan operator (+, -, *, /):", outContent.toString().trim());
        assertEquals('*', result);
    }

    @Test
    void testInputOpSalah1() {
        //setup
        System.setIn(new ByteArrayInputStream("\\\n".getBytes()));

        mockedStatic = mockStatic(IOHandler.class);
        mockedStatic.when(IOHandler::inputOperator).thenCallRealMethod();
        mockedStatic.when(IOHandler::cetakPesanInputOperator).thenReturn("Masukkan operator (+, -, *, /):");

        //exercise
        char result = IOHandler.inputOperator();

        //verify
        assertEquals("Masukkan operator (+, -, *, /):", outContent.toString().trim());
        assertEquals('\\', result);
    }

    @Test
    void testInputOpSalah2() {
        //setup
        System.setIn(new ByteArrayInputStream(">\n".getBytes()));

        mockedStatic = mockStatic(IOHandler.class);
        mockedStatic.when(IOHandler::inputOperator).thenCallRealMethod();
        mockedStatic.when(IOHandler::cetakPesanInputOperator).thenReturn("Masukkan operator (+, -, *, /):");

        //exercise
        char result = IOHandler.inputOperator();

        //verify
        assertEquals("Masukkan operator (+, -, *, /):", outContent.toString().trim());
        assertEquals('>', result);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        mockedStatic.close();
    }
}

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import com.najib.modules.Controller;
import com.najib.modules.IOHandler;
import com.najib.modules.IOHandler.InputAngka;
import com.najib.modules.Validator;
import com.najib.modules.Operator;

import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

public class RunKalkulatorTest {

    private MockedStatic<IOHandler> ioHandlerMock;
    private MockedStatic<Validator> validatorMock;
    private MockedStatic<Operator> operatorMock;

    @BeforeEach
    public void setUp() {
        ioHandlerMock = mockStatic(IOHandler.class);
        validatorMock = mockStatic(Validator.class);
        operatorMock = mockStatic(Operator.class);
    }

    @AfterEach
    public void tearDown() {
        ioHandlerMock.close();
        validatorMock.close();
        operatorMock.close();
    }

    @Test
    public void validThenTerminate() {
        // 1. Setup
        InputAngka input = new InputAngka("5", "2");
        ioHandlerMock.when(IOHandler::inputNomor).thenReturn(input);
        ioHandlerMock.when(IOHandler::inputOperator).thenReturn('/');
        validatorMock.when(() -> Validator.validasi("5", "2", '/')).thenReturn(true);
        operatorMock.when(() -> Operator.hitung(5, 2, '/')).thenReturn(2);

        // 2. Exercise
        int result = Controller.runKalkulator();

        // 3. Verify
        assertEquals(2, result);
    }

    @Test
    public void invalidThenTerminate() {
        // 1. Setup
        InputAngka input = new InputAngka("a", "2");
        ioHandlerMock.when(IOHandler::inputNomor).thenReturn(input);
        ioHandlerMock.when(IOHandler::inputOperator).thenReturn('+');
        validatorMock.when(() -> Validator.validasi("a", "2", '+')).thenReturn(false)
                .thenAnswer(invocation -> {
                    throw new RuntimeException("Exit after repeated failure");
                });

        // 2. Exercise & 3. Verify
        Assertions.assertThrows(RuntimeException.class, Controller::runKalkulator);
    }

    @Test
    public void validThenInvalid() {
        // 1. Setup
        InputAngka validInput = new InputAngka("4", "2");
        InputAngka invalidInput = new InputAngka("abc", "1");

        ioHandlerMock.when(IOHandler::inputNomor)
                .thenReturn(validInput) 
                .thenReturn(invalidInput); 
        ioHandlerMock.when(IOHandler::inputOperator).thenReturn('-'); 

        validatorMock.when(() -> Validator.validasi("4", "2", '-')).thenReturn(true); 
        validatorMock.when(() -> Validator.validasi("abc", "1", '-')).thenReturn(false);
        operatorMock.when(() -> Operator.hitung(4, 2, '-')).thenReturn(2); 

        // 2. Exercise
        int result = Controller.runKalkulator();

        // 3. Verify
        assertEquals(2, result); 

        // Verify inputNomor was called because invalid input was not processed
        ioHandlerMock.verify(IOHandler::inputNomor, times(1));

        // Verify inputOperator was called once because invalid input was not processed
        ioHandlerMock.verify(IOHandler::inputOperator, times(1));
    }

    @Test
    public void invalidThenValid() {
        // 1. Setup
        InputAngka invalidInput = new InputAngka("xyz", "2");
        InputAngka validInput = new InputAngka("6", "3");

        ioHandlerMock.when(IOHandler::inputNomor)
                .thenReturn(invalidInput)
                .thenReturn(validInput);
        ioHandlerMock.when(IOHandler::inputOperator).thenReturn('+');

        validatorMock.when(() -> Validator.validasi("xyz", "2", '+')).thenReturn(false);
        validatorMock.when(() -> Validator.validasi("6", "3", '+')).thenReturn(true);
        operatorMock.when(() -> Operator.hitung(6, 3, '+')).thenReturn(9);

        // 2. Exercise
        int result = Controller.runKalkulator();

        // 3. Verify
        assertEquals(9, result);

        // Verify that inputNomor was called twice (for both invalid and valid inputs)
        ioHandlerMock.verify(IOHandler::inputNomor, times(2));

        // Verify that inputOperator was called twice (for both invalid and valid
        // inputs)
        ioHandlerMock.verify(IOHandler::inputOperator, times(2));

        // Verify the validator and operator interactions
        validatorMock.verify(() -> Validator.validasi("xyz", "2", '+'));
        validatorMock.verify(() -> Validator.validasi("6", "3", '+'));
        operatorMock.verify(() -> Operator.hitung(6, 3, '+'));
    }

    @Test
    public void multipleValidThenTerminate() {
        // 1. Setup
        InputAngka input1 = new InputAngka("10", "5");
        InputAngka input2 = new InputAngka("6", "3");

        ioHandlerMock.when(IOHandler::inputNomor)
                .thenReturn(input1)
                .thenReturn(input2);
        ioHandlerMock.when(IOHandler::inputOperator)
                .thenReturn('+')
                .thenReturn('*');

        validatorMock.when(() -> Validator.validasi("10", "5", '+')).thenReturn(true);
        validatorMock.when(() -> Validator.validasi("6", "3", '*')).thenReturn(true);

        operatorMock.when(() -> Operator.hitung(10, 5, '+')).thenReturn(15);
        operatorMock.when(() -> Operator.hitung(6, 3, '*')).thenReturn(18);

        // 2. Exercise - Run kalkulator twice
        int result1 = Controller.runKalkulator();
        int result2 = Controller.runKalkulator();

        // 3. Verify
        assertEquals(15, result1);
        assertEquals(18, result2);

        // Verify the inputNomor and inputOperator calls happened twice
        ioHandlerMock.verify(IOHandler::inputNomor, times(2));
        ioHandlerMock.verify(IOHandler::inputOperator, times(2));

        // Verify the validator and operator methods
        validatorMock.verify(() -> Validator.validasi("10", "5", '+'));
        validatorMock.verify(() -> Validator.validasi("6", "3", '*'));
        operatorMock.verify(() -> Operator.hitung(10, 5, '+'));
        operatorMock.verify(() -> Operator.hitung(6, 3, '*'));
    }

    @Test
    public void invalidMultipleThenTerminate() {
        // 1. Setup
        InputAngka input1 = new InputAngka("a", "2");
        InputAngka input2 = new InputAngka("3", "b");
        InputAngka input3 = new InputAngka("!", "!");

        ioHandlerMock.when(IOHandler::inputNomor)
                .thenReturn(input1)
                .thenReturn(input2)
                .thenReturn(input3);

        ioHandlerMock.when(IOHandler::inputOperator)
                .thenReturn('+')
                .thenReturn('-')
                .thenReturn('*');

        validatorMock.when(() -> Validator.validasi(anyString(), anyString(), anyChar()))
                .thenReturn(false)
                .thenReturn(false)
                .thenAnswer(invocation -> {
                    throw new RuntimeException("Terminated after multiple invalid attempts");
                });

        // 2. Exercise - Run kalkulator once, expect invalid inputs for multiple
        // iterations
        Assertions.assertThrows(RuntimeException.class, Controller::runKalkulator);

        // 3. Verify - Ensure inputNomor is called 3 times (one for each input) and
        // inputOperator 3 times
        ioHandlerMock.verify(IOHandler::inputNomor, times(3)); // Expecting 3 times as 3 invalid inputs
        ioHandlerMock.verify(IOHandler::inputOperator, times(3)); // Expecting 3 times as 3 operator inputs

        // Verify the validator calls
        validatorMock.verify(() -> Validator.validasi("a", "2", '+'));
        validatorMock.verify(() -> Validator.validasi("3", "b", '-'));
        validatorMock.verify(() -> Validator.validasi("!", "!", '*'));
    }

    @Test
    public void terminateEarly() {
        // 1. Setup
        ioHandlerMock.when(IOHandler::inputNomor).thenReturn(null); // User quit

        // 2. Exercise & 3. Verify
        Assertions.assertThrows(NullPointerException.class, Controller::runKalkulator);
    }

}

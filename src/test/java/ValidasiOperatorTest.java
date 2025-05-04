import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.najib.modules.Validator.validasiOperator;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidasiOperatorTest {
    @Test
    @DisplayName("Menguji operator yang valid yaitu +")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void operatorValidTest() {
        // 1. setup (arrange)
        char operator = '+';
        boolean actual;

        // 2. exercise (act)
        actual = validasiOperator(operator);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji operator yang valid yaitu -")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void operatorValidMinusTest() {
        // 1. setup (arrange)
        char operator = '-';
        boolean actual;

        // 2. exercise (act)
        actual = validasiOperator(operator);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji operator yang valid yaitu *")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void operatorValidKaliTest() {
        // 1. setup (arrange)
        char operator = '*';
        boolean actual;

        // 2. exercise (act)
        actual = validasiOperator(operator);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji operator yang valid yaitu /")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void operatorValidBagiTest() {
        // 1. setup (arrange)
        char operator = '/';
        boolean actual;

        // 2. exercise (act)
        actual = validasiOperator(operator);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji operator selain yang diperbolehkan")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void operatorInvalidTest() {
        // 1. setup (arrange)
        char operator = '^';
        boolean actual;

        // 2. exercise (act)
        actual = validasiOperator(operator);

        // 3. verify (assert)
        assertFalse(actual);
    }
}

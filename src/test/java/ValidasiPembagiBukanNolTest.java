import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.najib.modules.Validator.validasiPembagiBukanNol;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidasiPembagiBukanNolTest {
    @Test
    @DisplayName("Menguji pembagi bukan nol")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void pembagiBukanNolTest() {
        // 1. setup (arrange)
        int b = 2;
        boolean actual;

        // 2. exercise (act)
        actual = validasiPembagiBukanNol(b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji pembagi nol")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void pembagiNolTest() {
        // 1. setup (arrange)
        int b = 0;
        boolean actual;

        // 2. exercise (act)
        actual = validasiPembagiBukanNol(b);

        // 3. verify (assert)
        assertFalse(actual);
    }
}

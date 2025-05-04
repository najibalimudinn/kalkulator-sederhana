import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.najib.modules.Validator.validasiTipeData;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidasiTipeDataTest {
    @Test
    @DisplayName("Menguji tipe data input yang valid")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void tipeDataValidTest() {
        // 1. setup (arrange)
        String input_a = "123";
        String input_b = "456";
        boolean actual;

        // 2. exercise (act)
        actual = validasiTipeData(input_a, input_b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji tipe data input pertama yang tidak valid")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void tipeDataInputPertamaInvalidTest() {
        // 1. setup (arrange)
        String a = "123a";
        String b = "456";
        boolean actual;

        // 2. exercise (act)
        actual = validasiTipeData(a, b);

        // 3. verify (assert)
        assertFalse(actual);
    }

    @Test
    @DisplayName("Menguji tipe data input kedua yang tidak valid")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void tipeDataInputKeduaInvalidTest() {
        // 1. setup (arrange)
        String a = "123";
        String b = "456a";
        boolean actual;

        // 2. exercise (act)
        actual = validasiTipeData(a, b);

        // 3. verify (assert)
        assertFalse(actual);
    }

    @Test
    @DisplayName("Menguji tipe data keduanya input yang tidak valid")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void tipeDataKeduanyaInvalidTest() {
        // 1. setup (arrange)
        String a = "123a";
        String b = "456a";
        boolean actual;

        // 2. exercise (act)
        actual = validasiTipeData(a, b);

        // 3. verify (assert)
        assertFalse(actual);
    }
}
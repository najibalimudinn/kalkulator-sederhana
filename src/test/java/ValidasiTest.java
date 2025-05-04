import com.najib.modules.Validator;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockStatic;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidasiTest {
    @Test
    @DisplayName("Menguji masukan yang valid")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void validasiInputValidTest() {
        // 1. setup (arrange)
        String a = "123";
        String b = "456";
        char operator = '+';
        boolean actual;

        // 2. exercise (act)
        try (MockedStatic<Validator> mockedStatic = mockStatic(Validator.class, CALLS_REAL_METHODS)) {
            // Mock semua method validasi static agar return true
            mockedStatic.when(() -> Validator.validasiTipeData(a, b)).thenReturn(true);
            mockedStatic.when(() -> Validator.validasiRentang(123, 456)).thenReturn(true);
            mockedStatic.when(() -> Validator.validasiOperator(operator)).thenReturn(true);
            mockedStatic.when(() -> Validator.validasiPembagiBukanNol(456)).thenReturn(true);

            // Kita biarkan validasi() tetap dipanggil metode aslinya
            actual = Validator.validasi(a, b, operator);
        }

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji pembagi yang tidak valid")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void validasiPembagiNolTest() {
        // 1. setup (arrange)
        String a = "123";
        String b = "0";
        char operator = '/';
        boolean actual;

        // 2. exercise (act)
        try (MockedStatic<Validator> mockedStatic = mockStatic(Validator.class, CALLS_REAL_METHODS)) {
            // Mock semua method validasi static agar return true
            mockedStatic.when(() -> Validator.validasiTipeData(a, b)).thenReturn(true);
            mockedStatic.when(() -> Validator.validasiRentang(123, 0)).thenReturn(true);
            mockedStatic.when(() -> Validator.validasiOperator(operator)).thenReturn(true);
            mockedStatic.when(() -> Validator.validasiPembagiBukanNol(0)).thenReturn(false);

            // Kita biarkan validasi() tetap dipanggil metode aslinya
            actual = Validator.validasi(a, b, operator);
        }

        // 3. verify (assert)
        assertFalse(actual);
    }

    @Test
    @DisplayName("Menguji tipe data yang tidak valid")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void validasiTipeDataInvalidTest() {
        // 1. setup (arrange)
        String a = "abc";
        String b = "def";
        char operator = '+';
        boolean actual;

        // 2. exercise (act)
        try (MockedStatic<Validator> mockedStatic = mockStatic(Validator.class, CALLS_REAL_METHODS)) {
            // Mock semua method validasi static agar return true
            mockedStatic.when(() -> Validator.validasiTipeData(a, b)).thenReturn(false);

            // Kita biarkan validasi() tetap dipanggil metode aslinya
            actual = Validator.validasi(a, b, operator);
        }

        // 3. verify (assert)
        assertFalse(actual);
    }

    @Test
    @DisplayName("Menguji rentang masukan angka yang tidak valid")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void validasiRentangInvalidTest() {
        // 1. setup (arrange)
        String a = "-100000";
        String b = "100000";
        char operator = '/';
        boolean actual;

        // 2. exercise (act)
        try (MockedStatic<Validator> mockedStatic = mockStatic(Validator.class, CALLS_REAL_METHODS)) {
            // Mock semua method validasi static agar return true
            mockedStatic.when(() -> Validator.validasiTipeData(a, b)).thenReturn(true);
            mockedStatic.when(() -> Validator.validasiRentang(-100000, 100000)).thenReturn(false);

            // Kita biarkan validasi() tetap dipanggil metode aslinya
            actual = Validator.validasi(a, b, operator);
        }

        // 3. verify (assert)
        assertFalse(actual);
    }

    @Test
    @DisplayName("Menguji operator yang tidak valid")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void validasiOperatorInvalidTest() {
        // 1. setup (arrange)
        String a = "123";
        String b = "456";
        char operator = '^';
        boolean actual;

        // 2. exercise (act)
        try (MockedStatic<Validator> mockedStatic = mockStatic(Validator.class, CALLS_REAL_METHODS)) {
            // Mock semua method validasi static agar return true
            mockedStatic.when(() -> Validator.validasiTipeData(a, b)).thenReturn(true);
            mockedStatic.when(() -> Validator.validasiRentang(123, 456)).thenReturn(true);
            mockedStatic.when(() -> Validator.validasiOperator(operator)).thenReturn(false);

            // Kita biarkan validasi() tetap dipanggil metode aslinya
            actual = Validator.validasi(a, b, operator);
        }

        // 3. verify (assert)
        assertFalse(actual);
    }
}

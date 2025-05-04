import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.najib.modules.Validator.validasiRentang;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidasiRentangTest {
    @Test
    @DisplayName("Menguji kedua angka berada dalam rentang -32768 sampai dengan 32767")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangValidTest() {
        // 1. setup (arrange)
        int a = 12;
        int b = 13;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji angka pertama pada batas bawah rentang")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangPertamaBatasBawahTest() {
        // 1. setup (arrange)
        int a = -32768;
        int b = 0;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji angka pertama pada batas atas rentangPertama")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangPertamaBatasAtasTest() {
        // 1. setup (arrange)
        int a = 32767;
        int b = 0;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji angka pertama pada tepi bawah rentang")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangPertamaTepiBawahTest() {
        // 1. setup (arrange)
        int a = -32767;
        int b = 0;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji angka pertama pada tepi atas rentang")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangPertamaTepiAtasTest() {
        // 1. setup (arrange)
        int a = 32766;
        int b = 0;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji angka kedua pada batas bawah rentang")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangKeduaBatasBawahTest() {
        // 1. setup (arrange)
        int a = 0;
        int b = -32768;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji angka kedua pada batas atas rentang")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangKeduaBatasAtasTest() {
        // 1. setup (arrange)
        int a = 0;
        int b = 32767;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji angka kedua pada tepi bawah rentang")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangKeduaTepiBawahTest() {
        // 1. setup (arrange)
        int a = 0;
        int b = -32767;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji angka kedua pada tepi atas rentang")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangKeduaTepiAtasTest() {
        // 1. setup (arrange)
        int a = 0;
        int b = 32766;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertTrue(actual);
    }

    @Test
    @DisplayName("Menguji angka pertama di luar rentang yaitu bernilai lebih dari 32767")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangPertamaLebihDariBatasAtasTest() {
        // 1. setup (arrange)
        int a = 32768;
        int b = 0;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertFalse(actual);
    }

    @Test
    @DisplayName("Menguji angka pertama di luar rentang yaitu bernilai kurang dari -32768")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangPertamaKurangDariBatasBawahTest() {
        // 1. setup (arrange)
        int a = -32769;
        int b = 0;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertFalse(actual);
    }

    @Test
    @DisplayName("Menguji angka kedua di luar rentang yaitu bernilai lebih dari 32767")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangKeduaLebihDariBatasAtasTest() {
        // 1. setup (arrange)
        int a = 0;
        int b = 32768;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertFalse(actual);
    }

    @Test
    @DisplayName("Menguji angka kedua di luar rentang yaitu bernilai kurang dari -32768")
    @Owner("Najib")
    @Severity(SeverityLevel.BLOCKER)
    public void rentangKeduaKurangDariBatasBawahTest() {
        // 1. setup (arrange)
        int a = 0;
        int b = -32769;
        boolean actual;

        // 2. exercise (act)
        actual = validasiRentang(a, b);

        // 3. verify (assert)
        assertFalse(actual);
    }
}

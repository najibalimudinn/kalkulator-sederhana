import static org.junit.jupiter.api.Assertions.assertEquals;
import com.najib.modules.Operator;

import org.junit.jupiter.api.*;

class kaliTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testKaliAngkaPositif() {
        //setup
        int a = 2;
        int b = 8;

        //exercise
        int hasil = Operator.kali(a, b);

        //verify
        assertEquals(16, hasil);
    }

    @Test
    void testKaliAngkaPosNeg() {
        //setup
        int a = 5;
        int b = -7;

        //exercise
        int hasil = Operator.kali(a, b);

        //verify
        assertEquals(-35, hasil);
    }

    @Test
    void testKaliAngkaNegPos() {
        //setup
        int a = -5;
        int b = 7;

        //exercise
        int hasil = Operator.kali(a, b);

        //verify
        assertEquals(-35, hasil);
    }

    @Test
    void testKaliAngkaNolPos() {
        //setup
        int a = 0;
        int b = 3;

        //exercise
        int hasil = Operator.kali(a, b);

        //verify
        assertEquals(0, hasil);
    }

    @Test
    void testKaliAngkaNolNeg() {
        //setup
        int a = 0;
        int b = -3;

        //exercise
        int hasil = Operator.kali(a, b);

        //verify
        assertEquals(0, hasil);
    }

    @Test
    void testKaliAngkaNegatif() {
        //setup
        int a = -4;
        int b = -2;

        //exercise
        int hasil = Operator.kali(a, b);

        //verify
        assertEquals(8, hasil);
    }

    @AfterEach
    void tearDown() {
        // Tidak diperlukan untuk test ini, tapi bisa digunakan untuk cleanup
    }
}

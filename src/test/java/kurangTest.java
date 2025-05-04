import static org.junit.jupiter.api.Assertions.assertEquals;
import com.najib.modules.Operator;

import org.junit.jupiter.api.*;

class kurangTest {

    Operator operator;

    @BeforeEach
    void setUp() {
        operator = new Operator(); // Gunakan implementasi asli
    }

    @Test
    void testKurangAngkaPositif() {
        //setup
        int a = 2;
        int b = 8;

        //exercise
        int hasil = operator.kurang(a, b);

        //verify
        assertEquals(-6, hasil);
    }

    @Test
    void testKurangAngkaPosNeg() {
        //setup
        int a = 5;
        int b = -7;

        //exercise
        int hasil = operator.kurang(a, b);

        //verify
        assertEquals(12, hasil);
    }

    @Test
    void testKurangAngkaNegPos() {
        //setup
        int a = -5;
        int b = 7;

        //exercise
        int hasil = operator.kurang(a, b);

        //verify
        assertEquals(-12, hasil);
    }

    @Test
    void testKurangAngkaNolPos() {
        //setup
        int a = 0;
        int b = 3;

        //exercise
        int hasil = operator.kurang(a, b);

        //verify
        assertEquals(-3, hasil);
    }

    @Test
    void testKurangAngkaNolNeg() {
        //setup
        int a = 0;
        int b = -3;

        //exercise
        int hasil = operator.kurang(a, b);

        //verify
        assertEquals(3, hasil);
    }

    @Test
    void testKurangAngkaNegatif() {
        //setup
        int a = -4;
        int b = -2;

        //exercise
        int hasil = operator.kurang(a, b);

        //verify
        assertEquals(-2, hasil);
    }

    @AfterEach
    void tearDown() {
        // Tidak diperlukan untuk test ini, tapi bisa digunakan untuk cleanup
    }
}

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.najib.modules.Operator;

import org.junit.jupiter.api.*;

class bagiTest {

    Operator operator;

    @BeforeEach
    void setUp() {
        operator = new Operator(); // Gunakan implementasi asli
    }

    @Test
    void testKurangAngkaPositif() {
        //setup
        int a = 8;
        int b = 2;

        //exercise
        int hasil = operator.bagi(a, b);

        //verify
        assertEquals(4, hasil);
    }

    @Test
    void testKurangAngkaPosNeg() {
        //setup
        int a = 14;
        int b = -7;

        //exercise
        int hasil = operator.bagi(a, b);

        //verify
        assertEquals(-2, hasil);
    }

    @Test
    void testKurangAngkaNegPos() {
        //setup
        int a = -7;
        int b = 2;

        //exercise
        int hasil = operator.bagi(a, b);

        //verify
        assertEquals(-3.5, hasil);
    }

    @Test
    void testKurangAngkaNolPos() {
        //setup
        int a = 0;
        int b = 3;

        //exercise
        int hasil = operator.bagi(a, b);

        //verify
        assertEquals(0, hasil);
    }

    @Test
    void testKurangAngkaNolNeg() {
        //setup
        int a = 0;
        int b = -3;

        //exercise
        int hasil = operator.bagi(a, b);

        //verify
        assertEquals(0, hasil);
    }

    @Test
    void testKurangAngkaNegatif() {
        //setup
        int a = -4;
        int b = -2;

        //exercise
        int hasil = operator.bagi(a, b);

        //verify
        assertEquals(2, hasil);
    }

    @AfterEach
    void tearDown() {
        // Tidak diperlukan untuk test ini, tapi bisa digunakan untuk cleanup
    }
}

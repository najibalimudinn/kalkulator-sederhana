import static org.junit.jupiter.api.Assertions.assertEquals;
import com.najib.modules.Operator;

import org.junit.jupiter.api.*;

class tambahTest {

    Operator operator;

    @BeforeEach
    void setUp() {
        operator = new Operator();
    }

    @Test
    void testTambahAngkaPositif() {
        //setup
        int a = 2;
        int b = 8;

        //exercise
        int hasil = operator.tambah(a, b);

        //verify
        assertEquals(10, hasil);
    }

    @Test
    void testTambahAngkaPosNeg() {
        //setup
        int a = 5;
        int b = -7;

        //exercise
        int hasil = operator.tambah(a, b);

        //verify
        assertEquals(-2, hasil);
    }

    @Test
    void testTambahAngkaNegPos() {
        //setup
        int a = -5;
        int b = 7;

        //exercise
        int hasil = operator.tambah(a, b);

        //verify
        assertEquals(2, hasil);
    }

    @Test
    void testTambahAngkaNolPos() {
        //setup
        int a = 0;
        int b = 3;

        //exercise
        int hasil = operator.tambah(a, b);

        //verify
        assertEquals(3, hasil);
    }

    @Test
    void testTambahAngkaNolNeg() {
        //setup
        int a = 0;
        int b = -3;

        //exercise
        int hasil = operator.tambah(a, b);

        //verify
        assertEquals(-3, hasil);
    }

    @Test
    void testTambahAngkaNegatif() {
        //setup
        int a = -4;
        int b = -2;

        //exercise
        int hasil = operator.tambah(a, b);

        //verify
        assertEquals(-6, hasil);
    }

    @AfterEach
    void tearDown() {
        // Tidak diperlukan untuk test ini, tapi bisa digunakan untuk cleanup
    }
}

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.najib.modules.Operator;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

class hitungTest {

    MockedStatic<Operator> mockedStatic;

    @BeforeEach
    void setUp() {
        mockedStatic = mockStatic(Operator.class);
    }

    @Test
    void testHitungDenganOpTambah1() {
        // Setup
        mockedStatic.when(() -> Operator.tambah(5, 3)).thenReturn(8);
        mockedStatic.when(() -> Operator.hitung(5, 3, '+')).thenCallRealMethod();

        // Exercise
        int hasil = Operator.hitung(5, 3, '+');

        // Verify
        assertEquals(8, hasil);
        mockedStatic.verify(() -> Operator.tambah(5, 3));
    }

    @Test
    void testHitungDenganOpTambah2() {
        // Setup
        mockedStatic.when(() -> Operator.tambah(-5, -3)).thenReturn(-8);
        mockedStatic.when(() -> Operator.hitung(-5, -3, '+')).thenCallRealMethod();

        // Exercise
        int hasil = Operator.hitung(-5, -3, '+');

        // Verify
        assertEquals(-8, hasil);
        mockedStatic.verify(() -> Operator.tambah(-5, -3));
    }

    @Test
    void testHitungDenganOpKurang1() {
        // Setup
        mockedStatic.when(() -> Operator.kurang(5, 3)).thenReturn(2);
        mockedStatic.when(() -> Operator.hitung(5, 3, '-')).thenCallRealMethod();

        // Exercise
        int hasil = Operator.hitung(5, 3, '-');

        // Verify
        assertEquals(2, hasil);
        mockedStatic.verify(() -> Operator.kurang(5, 3));
    }

    @Test
    void testHitungDenganOpKurang2() {
        // Setup
        mockedStatic.when(() -> Operator.kurang(-5, -3)).thenReturn(-2);
        mockedStatic.when(() -> Operator.hitung(-5, -3, '-')).thenCallRealMethod();

        // Exercise
        int hasil = Operator.hitung(-5, -3, '-');

        // Verify
        assertEquals(-2, hasil);
        mockedStatic.verify(() -> Operator.kurang(-5, -3));
    }

    @Test
    void testHitungDenganOpKali1() {
        // Setup
        mockedStatic.when(() -> Operator.kali(5, 3)).thenReturn(15);
        mockedStatic.when(() -> Operator.hitung(5, 3, '*')).thenCallRealMethod();

        // Exercise
        int hasil = Operator.hitung(5, 3, '*');

        // Verify
        assertEquals(15, hasil);
        mockedStatic.verify(() -> Operator.kali(5, 3));
    }

    @Test
    void testHitungDenganOpKali2() {
        // Setup
        mockedStatic.when(() -> Operator.kali(-3, -4)).thenReturn(12);
        mockedStatic.when(() -> Operator.hitung(-3, -4, '*')).thenCallRealMethod();

        // Exercise
        int hasil = Operator.hitung(-3, -4, '*');

        // Verify
        assertEquals(12, hasil);
        mockedStatic.verify(() -> Operator.kali(-3, -4));
    }

    @Test
    void testHitungDenganOpKali3() {
        // Setup
        mockedStatic.when(() -> Operator.kali(3, -4)).thenReturn(-12);
        mockedStatic.when(() -> Operator.hitung(3, -4, '*')).thenCallRealMethod();

        // Exercise
        int hasil = Operator.hitung(3, -4, '*');

        // Verify
        assertEquals(-12, hasil);
        mockedStatic.verify(() -> Operator.kali(3, -4));
    }

    @Test
    void testHitungDenganOpBagi1() {
        // Setup
        mockedStatic.when(() -> Operator.bagi(6, 3)).thenReturn(2);
        mockedStatic.when(() -> Operator.hitung(6, 3, '/')).thenCallRealMethod();

        // Exercise
        int hasil = Operator.hitung(6, 3, '/');

        // Verify
        assertEquals(2, hasil);
        mockedStatic.verify(() -> Operator.bagi(6, 3));
    }

    @Test
    void testHitungDenganOpBagi2() {
        // Setup
        mockedStatic.when(() -> Operator.bagi(-6, -3)).thenReturn(2);
        mockedStatic.when(() -> Operator.hitung(-6, -3, '/')).thenCallRealMethod();

        // Exercise
        int hasil = Operator.hitung(-6, -3, '/');

        // Verify
        assertEquals(2, hasil);
        mockedStatic.verify(() -> Operator.bagi(-6, -3));
    }

    @Test
    void testHitungDenganOpBagi3() {
        // Setup
        mockedStatic.when(() -> Operator.bagi(6, -3)).thenReturn(-2);
        mockedStatic.when(() -> Operator.hitung(6, -3, '/')).thenCallRealMethod();

        // Exercise
        int hasil = Operator.hitung(6, -3, '/');

        // Verify
        assertEquals(-2, hasil);
        mockedStatic.verify(() -> Operator.bagi(6, -3));
    }

    @AfterEach
    void tearDown() {
        if (mockedStatic != null) {
            mockedStatic.close(); // Bersihkan resource
        }
    }
}

package com.najib.modules;

import static com.najib.modules.IOHandler.cetakErrorTipeData;
import static com.najib.modules.IOHandler.cetakErrorRentang;
import static com.najib.modules.IOHandler.cetakErrorOperator;
import static com.najib.modules.IOHandler.cetakErrorPembagiNol;

public class Validator {
    public static boolean validasiTipeData(String input_a, String input_b) {
        // Validasi input harus angka
        boolean isValid;

        if (!input_a.matches("-?\\d+") || !input_b.matches("-?\\d+")) {
            cetakErrorTipeData();
            isValid = false;
        } else {
            isValid = true;
        }

        return isValid;
    }

    public static boolean validasiRentang(int a, int b) {
        // Validasi rentang nilai
        boolean isValid;

        if (a < -32768 || a > 32767 || b < -32768 || b > 32767) {
            cetakErrorRentang();
            isValid = false;
        } else {
            isValid = true;
        }

        return isValid;
    }

    public static boolean validasiOperator(char operator) {
        // Validasi operator
        boolean isValid;

        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            cetakErrorOperator();
            isValid = false;
        } else {
            isValid = true;
        }

        return isValid;
    }

    public static boolean validasiPembagiBukanNol(int b) {
        // Validasi pembagian bukan dengan nol
        boolean isValid;

        if (b == 0) {
            cetakErrorPembagiNol();
            isValid = false;
        } else {
            isValid = true;
        }

        return isValid;
    }

    public static boolean validasi(String input_a, String input_b, char operator) {
        boolean isValid = false;
        isValid = validasiTipeData(input_a, input_b);

        if (isValid) {
            int a = Integer.parseInt(input_a);
            int b = Integer.parseInt(input_b);
            isValid = validasiRentang(a, b);
            if (isValid) {
                isValid = validasiOperator(operator);
                if (isValid && operator == '/') {
                    isValid = validasiPembagiBukanNol(b);
                }
            }
        }

        return isValid;
    }
}

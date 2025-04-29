package com.najib.modules;

import static com.najib.modules.IOHandler.printDataTypeError;
import static com.najib.modules.IOHandler.printRangeError;
import static com.najib.modules.IOHandler.printOperatorError;
import static com.najib.modules.IOHandler.printDivisionByZeroError;

public class Validator {
    public static boolean validateDataType(String input_a, String input_b) {
        // Validasi input harus angka
        boolean isValid;

        if (!input_a.matches("-?\\d+") || !input_b.matches("-?\\d+")) {
            printDataTypeError();
            isValid = false;
        } else {
            isValid = true;
        }

        return isValid;
    }

    public static boolean validateRange(int a, int b) {
        // Validasi rentang nilai
        boolean isValid;

        if (a < -32768 || a > 32767 || b < -32768 || b > 32767) {
            printRangeError();
            isValid = false;
        } else {
            isValid = true;
        }

        return isValid;
    }

    public static boolean validateOperator(char operator) {
        // Validasi operator
        boolean isValid;

        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            printOperatorError();
            isValid = false;
        } else {
            isValid = true;
        }

        return isValid;
    }

    public static boolean validateDivisionByZero(int b) {
        // Validasi pembagian dengan nol
        boolean isValid;

        if (b == 0) {
            printDivisionByZeroError();
            isValid = false;
        } else {
            isValid = true;
        }

        return isValid;
    }

    public static boolean validate(String input_a, String input_b, char operator) {
        boolean isValid = false;
        isValid = validateDataType(input_a, input_b);

        if (isValid) {
            int a = Integer.parseInt(input_a);
            int b = Integer.parseInt(input_b);
            isValid = validateRange(a, b);
            if (isValid) {
                isValid = validateOperator(operator);
                if (isValid && operator == '/') {
                    isValid = validateDivisionByZero(b);
                }
            }
        }

        return isValid;
    }
}

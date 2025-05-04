package com.najib.modules;

import static com.najib.modules.Validator.validasi;
import static com.najib.modules.Operator.hitung;
import static com.najib.modules.IOHandler.inputNomer;
import static com.najib.modules.IOHandler.inputOperator;
import static com.najib.modules.IOHandler.input_a;
import static com.najib.modules.IOHandler.input_b;
import static com.najib.modules.IOHandler.operator;
import static com.najib.modules.IOHandler.cetakHasil;

public class Controller {
    public static void runKalkulator() {
        while(true) {
            inputNomer();
            inputOperator();

            if(validasi(input_a, input_b, operator)) {
                int a = Integer.parseInt(input_a);
                int b = Integer.parseInt(input_b);
                int hasil = hitung(a, b, operator);
                cetakHasil(a, b, operator, hasil);
                break;
            }
        }
    }
}

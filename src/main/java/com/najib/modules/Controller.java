package com.najib.modules;

import static com.najib.modules.Validator.validasi;
import static com.najib.modules.Operator.hitung;
import static com.najib.modules.IOHandler.inputNomer;
import static com.najib.modules.IOHandler.inputOperator;
import static com.najib.modules.IOHandler.InputAngka;

public class Controller {
    public static int runKalkulator() {
        while(true) {
            InputAngka inputAngka = inputNomer();
            char inputOperator = inputOperator();

            if(validasi(inputAngka.a(), inputAngka.b(), inputOperator)) {
                int a = Integer.parseInt(inputAngka.a());
                int b = Integer.parseInt(inputAngka.b());
                return hitung(a, b, inputOperator);
            }
        }
    }
}

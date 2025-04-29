package com.najib.modules;

import static com.najib.modules.Validator.validate;
import static com.najib.modules.Operator.calculate;
import static com.najib.modules.IOHandler.inputNumbers;
import static com.najib.modules.IOHandler.inputOperator;
import static com.najib.modules.IOHandler.input_a;
import static com.najib.modules.IOHandler.input_b;
import static com.najib.modules.IOHandler.operator;
import static com.najib.modules.IOHandler.printResult;

public class Controller {
    public static void runKalkulator() {
        while(true) {
            inputNumbers();
            inputOperator();

            if(validate(input_a, input_b, operator)) {
                int a = Integer.parseInt(input_a);
                int b = Integer.parseInt(input_b);
                int hasil = calculate(a, b, operator);
                printResult(a, b, operator, hasil);
                break;
            }
        }
    }
}

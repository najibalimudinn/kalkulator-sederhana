package com.najib.modules;

public class Operation {
    public static int calculate(int a, int b, char operation) {
        int hasil = 0;
        switch (operation) {
            case '+':
                hasil = a + b;
                break;
            case '-':
                hasil = a - b;
                break;
            case '*':
                hasil = a * b;
                break;
            case '/':
                hasil = a / b;
                break;
        }
        return hasil;
    }
}

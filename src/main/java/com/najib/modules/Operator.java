package com.najib.modules;

public class Operator {
    public static int tambah(int a, int b) {
        return a + b;
    }

    public static int kurang(int a, int b) {
        return a - b;
    }

    public static int kali(int a, int b) {
        return a * b;
    }

    public static int bagi(int a, int b) {
        return a / b;
    }

    public static int calculate(int a, int b, char operator) {
        int hasil = 0;
        switch (operator) {
            case '+':
                hasil = tambah(a, b);
                break;
            case '-':
                hasil = kurang(a, b);
                break;
            case '*':
                hasil = kali(a, b);
                break;
            case '/':
                hasil = bagi(a, b);
                break;
        }
        return hasil;
    }
}

package com.najib.modules;

public class Operation {
    public static int calculate(int a, int b, char operation) {
        return switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
    }
}

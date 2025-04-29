package com.najib.modules;

import java.util.Scanner;

public class IOHandler {
    public static String input_a;
    public static String input_b;
    public static char operator;

    public static void inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        printInputNumbersMessage();
        input_a = scanner.next();
        input_b = scanner.next();
    }

    public static void inputOperator() {
        Scanner scanner = new Scanner(System.in);
        printInputOperatorMessage();
        operator = scanner.next().charAt(0);
    }

    public static void printInputNumbersMessage() {
        System.out.print("Masukkan dua buah nilai (pisahkan dengan spasi): ");
    }

    public static void printInputOperatorMessage() {
        System.out.print("Masukkan operator (+, -, *, /): ");
    }

    public static void printDataTypeError() {
        System.out.println("\nError: Input harus berupa angka.");
    }

    public static void printRangeError() {
        System.out.println("\nError: Nilai di luar rentang yang diperbolehkan.");
    }

    public static void printOperatorError() {
        System.out.println("\nError: Operator tidak valid.");
    }

    public static void printDivisionByZeroError() {
        System.out.println("\nError: Pembagian dengan nol tidak diperbolehkan.");
    }

    public static void printResult(int a, int b, char operator, int hasil) {
        System.out.println("\nHasil: " + a + " " + operator + " " + b + " = " + hasil);
    }
}

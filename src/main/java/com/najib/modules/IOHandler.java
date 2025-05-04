package com.najib.modules;

import java.util.Scanner;

public class IOHandler {
    public static String input_a;
    public static String input_b;
    public static char operator;

    public static void inputNomer() {
        Scanner scanner = new Scanner(System.in);
        cetakPesanInputNomor();
        input_a = scanner.next();
        input_b = scanner.next();
    }

    public static void inputOperator() {
        Scanner scanner = new Scanner(System.in);
        cetakPesanInputOperator();
        operator = scanner.next().charAt(0);
    }

    public static void cetakPesanInputNomor() {
        System.out.print("Masukkan dua buah nilai (pisahkan dengan spasi): ");
    }

    public static void cetakPesanInputOperator() {
        System.out.print("Masukkan operator (+, -, *, /): ");
    }

    public static void cetakErrorTipeData() {
        System.out.println("\nError: Input harus berupa angka.");
    }

    public static void cetakErrorRentang() {
        System.out.println("\nError: Nilai di luar rentang yang diperbolehkan.");
    }

    public static void cetakErrorOperator() {
        System.out.println("\nError: Operator tidak valid.");
    }

    public static void cetakErrorPembagiNol() {
        System.out.println("\nError: Pembagian dengan nol tidak diperbolehkan.");
    }

    public static void cetakHasil(int a, int b, char operator, int hasil) {
        System.out.println("\nHasil: " + a + " " + operator + " " + b + " = " + hasil);
    }
}

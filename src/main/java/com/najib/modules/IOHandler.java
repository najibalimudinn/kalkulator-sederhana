package com.najib.modules;

import java.util.Scanner;

public class IOHandler {
    public record InputAngka(String a, String b) {}

    public static InputAngka inputNomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(cetakPesanInputNomor());
        return new InputAngka(scanner.next(), scanner.next());
    }

    public static char inputOperator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(cetakPesanInputOperator());
        return scanner.next().charAt(0);
    }

    public static String cetakPesanInputNomor() {
        return "Masukkan dua buah nilai (pisahkan dengan spasi): ";
    }

    public static String cetakPesanInputOperator() {
        return "Masukkan operator (+, -, *, /): ";
    }

    public static String cetakErrorTipeData() {
        return "Error: Input harus berupa angka.";
    }

    public static String cetakErrorRentang() {
        return "Error: Nilai di luar rentang yang diperbolehkan.";
    }

    public static String cetakErrorOperator() {
        return "Error: Operator tidak valid.";
    }

    public static String cetakErrorPembagiNol() {
        return "Error: Pembagian dengan nol tidak diperbolehkan.";
    }

    public static String cetakHasil(int hasil) {
        return "Hasil = " + hasil;
    }
}

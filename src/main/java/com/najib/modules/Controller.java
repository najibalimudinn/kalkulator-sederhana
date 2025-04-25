package com.najib.modules;

import java.util.Scanner;

public class Controller {
    public static int runKalkulator() {
        // Input dua buah nilai
        Scanner scanner = new Scanner(System.in);
        int hasil;
        int a = 0, b = 0;

        System.out.print("Masukkan dua buah nilai dalam rentang -32,768 hingga 32,767 (pisahkan dengan spasi): ");
        String input_a = scanner.next();
        String input_b = scanner.next();

        // Input operator
        System.out.print("Masukkan operasi yang ingin dilakukan (+, -, *, /): ");
        char operasi = scanner.next().charAt(0);

        // Validasi input harus angka, sesuai dengan rentang yang diperbolehkan, operasi valid, dan tidak ada pembagian dengan nol
        if (!input_a.matches("-?\\d+") || !input_b.matches("-?\\d+")) {
            System.out.println("\nError: Input harus berupa angka.");
            System.exit(1);
        } else {
            a = Integer.parseInt(input_a);
            b = Integer.parseInt(input_b);
            if (a < -32768 || a > 32767 || b < -32768 || b > 32767) {
                System.out.println("\nError: Nilai di luar rentang yang diperbolehkan.");
                System.exit(1);
            } else if (operasi != '+' && operasi != '-' && operasi != '*' && operasi != '/') {
                System.out.println("\nError: Operator tidak valid.");
                System.exit(1);
            } else if (operasi == '/' && b == 0) {
                System.out.println("\nError: Pembagian dengan nol tidak diperbolehkan.");
                System.exit(1);
            }
        }

        // Hitung hasil sesuai dengan operasi yang dipilih
        hasil = switch (operasi) {
            case '+' -> Tambah.tambah(a, b);
            case '-' -> Kurang.kurang(a, b);
            case '*' -> Kali.kali(a, b);
            case '/' -> Bagi.bagi(a, b);
            default -> 0;
        };

        // Tampilkan hasil
        return hasil;
    }
}

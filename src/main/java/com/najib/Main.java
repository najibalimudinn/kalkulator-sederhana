package com.najib;

import com.najib.modules.Controller;

public class Main {
    public static void main(String[] args) {
        System.out.println("Kalkulator Sederhana");
        System.out.println("==========================\n");
        int hasil = Controller.runKalkulator();
        System.out.println("\n==========================");
        System.out.println("Hasil: " + hasil);
    }
}
package com.najib;

import com.najib.modules.Controller;
import com.najib.modules.IOHandler;

public class Main {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nProgram terminated by user.");
        }));

        while(true) {
            int hasil = Controller.runKalkulator();
            System.out.println("\n" + IOHandler.cetakHasil(hasil) + "\n");
        }
    }
}
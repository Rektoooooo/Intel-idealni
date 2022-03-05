package com.company;

import java.util.*;

public class template {

    public static void main(String[] args) throws InterruptedException {

        int vstup = safeSken();

    }

    static int safeSken() {
        Scanner sken = new Scanner(System.in);
        int a = 0;
        while (true) {
            try {
                a = sken.nextInt();
                if (a < 0 || a > 7) {
                    System.out.println("Povolený input je 0-7. Zkus to znovu.");
                    continue;
                }
                return a;
            } catch (Exception e) {
                sken.nextLine();
                System.out.println("Zadal jsi String, double, nebo příliš velké číslo. Zkus to znovu.");
            }
        }

    }
}

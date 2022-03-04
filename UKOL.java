package com.company;

import java.util.*;

public class UKOL {

    static int kurva = 0;
    public static final String ANSI_BLACK_BACKGROUND = "\033[40m";
    public static final String ANSI_BLACK = "\033[0;30m";
    public static final String ANSI_WHITE = "\033[0;37m";
    public static final String ANSI_WHITE_BACKGROUND = "\033[47m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {

        int x = 0;
        int y = 0;

        Scanner sken = new Scanner(System.in);

        int[][] kresleni = new int[5][5];

        while (true) {


            for (int[] ints : kresleni) {

                for (int vypis : ints) {
                    if (vypis == 0) {
                        System.out.print(ANSI_BLACK+ANSI_BLACK_BACKGROUND+ "  "+vypis+ "  "+ANSI_RESET);
                    }
                    else if (vypis == 1) {
                        System.out.print(ANSI_WHITE+ANSI_WHITE_BACKGROUND+ "  "+vypis+ "  "+ANSI_RESET);
                    }
                }
                System.out.println();
            }

            System.out.println("Zadej sloupec");
            x = safeSken();

            System.out.println("Zadej radek");
            y = safeSken();

            kurva = kresleni[x][y];
            if (kurva == 0) {
                kresleni[x][y] = 1;
            } else if (kurva == 1) {
                kresleni[x][y] = 0;
            }
        }
    }
    static int safeSken() {
        Scanner sken = new Scanner(System.in);

        while (true) {
            try {
                kurva = sken.nextInt();
                kurva--;
                if (kurva < 0 || kurva > 4) {
                    System.out.println("Povolený input je 1-5. Zkus to znovu.");
                    continue;
                }
                break;
            } catch (Exception e) {
                sken.nextLine();
                System.out.println("Zadal jsi String, double, nebo příliš velké číslo. Zkus to znovu.");
            }
        }
        return kurva;
    }
}
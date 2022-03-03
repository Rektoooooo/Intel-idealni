package com.company;

import java.util.*;


public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\033[0;31m";
    public static final String ANSI_RED_BRIGHT = "\033[0;91m";
    public static final String ANSI_RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String ANSI_RED_BACKGROUND = "\033[41m";
    public static final String ANSI_GREEN = "\033[0;92m";
    public static final String ANSI_GREEN_BRIGHT = "\033[0;92m";
    public static final String ANSI_GREEN_BACKGROUND = "\033[42m";
    public static final String ANSI_BLUE = "\033[0;34m";
    public static final String ANSI_BLUE_BRIGHT = "\033[0;94m";
    public static final String ANSI_BLUE_BACKGROUND = "\033[44m";
    public static final String ANSI_BLACK = "\033[0;30m";
    public static final String ANSI_RED_BACKGROUND_BRIGHT = "\033[0;101m";
    public static final String ANSI_YELLOW_BOLD = "\033[1;33m";
    public static final String ANSI_BLACK_BACKGROUND = "\033[40m";

    public static void main(String[] args) throws InterruptedException {

        int sloupec = 0;
        int radek = 0;
        int naboje = 25;
        int rip = 14;
        boolean jednou = true;
        int cislaside = 1;




        int[][] pole = new int[8][8];

        int[][] polelode = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0},
        };

        while (naboje != 0 && rip > 0) {

            System.out.println(ANSI_BLACK_BACKGROUND +"     A    B    C    D    E    F    G    H  "+ ANSI_RESET);

            for (int[] ints : pole) {
                System.out.print(ANSI_BLACK_BACKGROUND +" " + cislaside + " "+ ANSI_RESET);
                cislaside++;
                for (int vypis : ints) {

                    if (vypis == 0) {
                        System.out.print(ANSI_BLUE_BRIGHT + ANSI_BLUE_BACKGROUND + "  " + vypis + "  " + ANSI_RESET);
                    } else if (vypis == 1) {
                        System.out.print(ANSI_GREEN_BRIGHT + ANSI_GREEN_BACKGROUND + "  " + vypis + "  " + ANSI_RESET);
                    } else if (vypis == 2) {
                        System.out.print(ANSI_RED_BACKGROUND + "  " + vypis + "  " + ANSI_RESET);
                    } else {
                        System.out.print("  " + vypis + "  ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            if (jednou) {
                System.out.println("Napoveda : 0 je netrefená pozice, 1 je trefená loď, 2 je trefená voda");
                jednou = false;
            }
            System.out.println("Zadej sloupec A-H a radek 1-8");
            int[] vstup = safeSken();
            radek = vstup[1];


            sloupec = vstup[0];
            System.out.println();
            if (polelode[radek][sloupec] == 1) {
                System.out.println(ANSI_GREEN + "Trefil jsi lod" + ANSI_RESET);
                polelode[radek][sloupec] = 3;
                pole[radek][sloupec] = 1;
                rip--;
            } else if (polelode[radek][sloupec] == 0) {
                System.out.println(ANSI_RED + "Nic si netrefil" + ANSI_RESET);
                polelode[radek][sloupec] = 2;
                pole[radek][sloupec] = 2;
            } else if (polelode[radek][sloupec] == 2) {
                System.out.println(ANSI_YELLOW_BOLD + "Sem jsi uz vystrelil je tu voda" + ANSI_RESET);
            } else if (polelode[radek][sloupec] == 3) {
                System.out.println(ANSI_YELLOW_BOLD + "Sem uz jsi vystrelil je tu lod" + ANSI_RESET);
            }
            naboje--;
            System.out.println("Mas " + naboje + " Naboju");
            System.out.println("Zbyva ti sestrelis " + rip + " lodi");
            System.out.println("Napoveda : 0 je netrefená pozice, 1 je trefená loď, 2 je trefená voda");
            cislaside = 1;
            Thread.sleep(3000);

        }
        if (rip == 0 && naboje == 0) {
            System.out.println(ANSI_GREEN + "KLAAAČ sestrelil jsi posledni lod na posledni naboj" + ANSI_RESET);
        } else if (rip == 0) {
            System.out.println(ANSI_GREEN + "Vyhravas sestrelil jsi vsechny lode s " + naboje + " prebytecnejma nabojema" + ANSI_RESET);
        } else if (naboje == 0) {
            System.out.println(ANSI_RED + "Dosli ti naboje prohravas" + ANSI_RESET);
        }
    }

    static int[] safeSken() {
        Scanner sken = new Scanner(System.in);
        String input = sken.nextLine();
        if (input.length() == 2) {

            List<String> radky = Arrays.asList(
                    "1", "2", "3", "4", "5", "6", "7", "8"
            );
            List<String> sloupce = Arrays.asList(
                    "A", "B", "C", "D", "E", "F", "G", "H"
            );
            char zradek = input.charAt(1);
            char zsloupec = input.charAt(0);
            int iradek = radky.indexOf(String.valueOf(zradek));
            int isloupec = sloupce.indexOf(String.valueOf(zsloupec));
            int[] result = new int[]{
                    isloupec, iradek
            };
            return result;

        }
        else {
            System.out.println("Musis zadat dva znaky nebo jsi neco zadal spatne");
        }
            return new int[0];
    }
}


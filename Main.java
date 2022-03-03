package com.company;

import java.util.*;


public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\033[0;31m";
    public static final String ANSI_RED_BACKGROUND = "\033[41m";
    public static final String ANSI_GREEN = "\033[0;32m";
    public static final String ANSI_GREEN_BRIGHT = "\033[0;92m";
    public static final String ANSI_GREEN_BACKGROUND = "\033[42m";
    public static final String ANSI_BLUE_BACKGROUND = "\033[44m";
    public static final String ANSI_BLACK = "\033[0;30m";
    public static final String ANSI_YELLOW_BOLD = "\033[1;33m";
    public static final String ANSI_YELLOW_BRIGHT = "\033[0;93m";
    public static final String ANSI_BLACK_BACKGROUND = "\033[40m";
    public static final String ANSI_WHITE = "\033[0;37m";

    public static void main(String[] args) throws InterruptedException {

        int sloupec = 0;
        int radek = 0;
        int naboje = 25;
        int rip = 14;
        boolean jednou = true;
        int cislaside = 1;


        String[][] pole = new String[][]{
                {"-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-"}
        };

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

            System.out.println(ANSI_BLACK_BACKGROUND + "     A    B    C    D    E    F    G    H  " + ANSI_RESET);

            for (String[] ints : pole) {
                System.out.print(ANSI_BLACK_BACKGROUND + " " + cislaside + " " + ANSI_RESET);
                cislaside++;
                for (String vypis : ints) {

                    if (vypis == "-") {
                        System.out.print(ANSI_BLACK + ANSI_BLUE_BACKGROUND + "  " + vypis + "  " + ANSI_RESET);
                    } else if (vypis == "O") {
                        System.out.print(ANSI_GREEN_BRIGHT + ANSI_GREEN_BACKGROUND + "  " + vypis + "  " + ANSI_RESET);
                    } else if (vypis == "X") {
                        System.out.print(ANSI_RED_BACKGROUND + "  " + vypis + "  " + ANSI_RESET);
                    } else {
                        System.out.print("  " + vypis + "  ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            if (jednou) {
                System.out.println("Nápověda : " + ANSI_WHITE + "0 je nezasažená pozice," + ANSI_RESET + ANSI_GREEN_BRIGHT + " 1 je zasažená loď," + ANSI_RESET + ANSI_YELLOW_BOLD + " 2 je zasažená voda" + ANSI_RESET);
                jednou = false;
            }
            System.out.println("Zadej sloupec A-H a řádek 1-8");
            int[] vstup = safeSken();
            radek = vstup[1];


            sloupec = vstup[0];
            System.out.println();
            if (polelode[radek][sloupec] == 1) {
                System.out.println(ANSI_GREEN_BRIGHT + "Zasáhl jsi loď" + ANSI_RESET);
                polelode[radek][sloupec] = 3;
                pole[radek][sloupec] = "O";
                rip--;
            } else if (polelode[radek][sloupec] == 0) {
                System.out.println(ANSI_RED + "Nic si nezasáhl" + ANSI_RESET);
                polelode[radek][sloupec] = 2;
                pole[radek][sloupec] = "X";
            } else if (polelode[radek][sloupec] == 2) {
                System.out.println(ANSI_YELLOW_BOLD + "Sem jsi už vystřelil je tu voda" + ANSI_RESET);
            } else if (polelode[radek][sloupec] == 3) {
                System.out.println(ANSI_YELLOW_BOLD + "Sem jsi už vystřelil je tu loď" + ANSI_RESET);
            }
            naboje--;
            if (naboje >= 18) {
                System.out.println(ANSI_GREEN_BRIGHT + "Máš " + naboje + " nábojů" + ANSI_RESET);
            }
            else if (naboje >= 10) {
                System.out.println(ANSI_YELLOW_BRIGHT + "Máš " + naboje + " nábojů" + ANSI_RESET);
            }
            else {
                System.out.println(ANSI_RED + "Máš " + naboje + " nábojů" + ANSI_RESET);
            }
            if (rip >= 10) {
                System.out.println(ANSI_RED + "Zbýva ti sestřelit " + rip + " lodí" + ANSI_RESET);
            }
            else if (rip >= 5) {
                System.out.println(ANSI_YELLOW_BRIGHT + "Zbýva ti sestřelit " + rip + " lodí" + ANSI_RESET);
            }
            else {
                System.out.println(ANSI_GREEN_BRIGHT + "Zbýva ti sestřelit " + rip + " lodí" + ANSI_RESET);
            }
            cislaside = 1;
            System.out.println("Načítaní Mapy");
            Thread.sleep(1000);
            System.out.println(ANSI_RED + "33%" + ANSI_RESET);
            Thread.sleep(1000);
            System.out.println(ANSI_YELLOW_BRIGHT + "66%" + ANSI_RESET);
            Thread.sleep(1000);
            System.out.println(ANSI_GREEN_BRIGHT + "99%" + ANSI_RESET);

            System.out.println("Nápověda : " + ANSI_WHITE + "0 je nezasažená pozice," + ANSI_RESET + ANSI_GREEN_BRIGHT + " 1 je zasažená loď," + ANSI_RESET + ANSI_YELLOW_BOLD + " 2 je zasažená voda" + ANSI_RESET);
        }
        if (rip == 0 && naboje == 0) {
            System.out.println(ANSI_GREEN_BRIGHT + "KLAAAČ sestřelil jsi poslední loď na poslední náboj" + ANSI_RESET);
        } else if (rip == 0) {
            System.out.println(ANSI_GREEN + "Vyhrávaš sestřelil jsi všechny lodě v zasobníku ti zbýva" + naboje + ANSI_RESET);
        } else if (naboje == 0) {
            System.out.println(ANSI_RED + "Došli ti náboje zbývalo ti sestřelit " + rip + " lodí prohráváš" + ANSI_RESET);
        }
    }

    static int[] safeSken() {
        Scanner sken = new Scanner(System.in);
        int[] pls = new int[2];
        int fix = 0;

        char[] sloupce = {
                '1', '2', '3', '4', '5', '6', '7', '8'
        };

        char[] radky = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'
        };

        while (true) {

            String input = sken.nextLine();
            try {
                for (char a : radky) {
                    if (a == (input.charAt(0))) {
                        fix++;
                    }
                }
                for (char a : sloupce) {
                    if (a == (input.charAt(1))) {
                        fix++;
                    }
                }
            }
            catch (Exception e) {
                fix = 0;
                System.out.println(ANSI_RED + "Zadal jsi neplatné souřadnice." + ANSI_RESET + ANSI_YELLOW_BRIGHT + " Zkus to znovu." + ANSI_RESET);
                continue;
            }


            if (input.length() == 2 && fix == 2) {

                for (int i = 0; i < sloupce.length; i++) {
                    if (sloupce[i] == input.charAt(1)) {
                        pls[1] = i;
                    }
                }
                for (int i = 0; i < radky.length; i++) {
                    if (radky[i] == input.charAt(0)) {
                        pls[0] = i;
                    }
                }

                return pls;

            } else {
                fix = 0;
                System.out.println(ANSI_RED + "Zadal jsi neplatné souřadnice." + ANSI_RESET + ANSI_YELLOW_BRIGHT + " Zkus to znovu." + ANSI_RESET);
            }
        }
    }
}

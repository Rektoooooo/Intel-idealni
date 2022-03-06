package com.company;


import java.io.IOException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;


public class Main {

    public static final String ANSI_RESET = "\033[0m";
    public static final String ANSI_BLACK_BACKGROUND = "\033[40m";
    public static final String ANSI_BLUE_BACKGROUND = "\033[44m";

    public static void main(String[] args) throws InterruptedException {

        int karticky = 8;
        int sloupec = 0;
        int radek = 0;
        int sloupec1 = 0;
        int radek1 = 0;
        int input = 0;
        int input1 = 0;
        String mezi = "";


        String[][] pole = new String[][]{
                {"❓", "❓", "❓", "❓"},
                {"❓", "❓", "❓", "❓"},
                {"❓", "❓", "❓", "❓"},
                {"❓", "❓", "❓", "❓"},


        };

        int[][] karty = new int[][]{
                {1, 1, 2, 2},
                {3, 3, 4, 4},
                {5, 5, 6, 6},
                {7, 7, 8, 8}
        };

        ArrayList<Integer> hodnoty = new ArrayList<Integer>();
        hodnoty.add(1);
        hodnoty.add(1);
        hodnoty.add(2);
        hodnoty.add(2);
        hodnoty.add(3);
        hodnoty.add(3);
        hodnoty.add(4);
        hodnoty.add(4);
        hodnoty.add(5);
        hodnoty.add(5);
        hodnoty.add(6);
        hodnoty.add(6);
        hodnoty.add(7);
        hodnoty.add(7);
        hodnoty.add(8);
        hodnoty.add(8);


        for (int radecka = 0; radecka < 4; radecka++) {
            for (int sloupecek = 0; sloupecek < 4; sloupecek++) {
                int index = (int) (Math.random() * hodnoty.size());
                karty[radecka][sloupecek] = hodnoty.get(index);
                hodnoty.remove(index);
            }
        }

        hraciplocha(pole);

        while (karticky > 0) {


            System.out.println("Zadej sloupec A-D a řádek 1-4 pro zvoleni prvni karticky");

            int[] vstup = safeSken(pole);
            radek = vstup[1];
            sloupec = vstup[0];
            input = karty[radek][sloupec];

            pole[radek][sloupec] = convert(input);
            hraciplocha(pole);

            System.out.println("Zadej sloupec A-D a řádek 1-4 pro zvoleni druhy karticky");
            int[] vstup1 = safeSken(pole);
            radek1 = vstup1[1];
            sloupec1 = vstup1[0];
            input1 = karty[radek1][sloupec1];


            pole[radek1][sloupec1] = convert(input1);

            if (input != input1) {
                System.out.println("Nenasel jsi par");
                hraciplocha(pole);
                System.out.println("Karticky se otoci za");
                Thread.sleep(1000);
                System.out.print("4");
                Thread.sleep(1000);
                System.out.print("\r");
                System.out.print("3");
                Thread.sleep(1000);
                System.out.print("\r");
                System.out.print("2");
                Thread.sleep(1000);
                System.out.print("\r");
                System.out.print("1");
                Thread.sleep(1000);
                pole[radek][sloupec] = "❓";
                pole[radek1][sloupec1] = "❓";
                clearConsole();
            } else {
                System.out.println();
                System.out.println("Hezky !!! Nasel jsi par");
                System.out.println();
                karticky--;
            }

            hraciplocha(pole);


        }
        System.out.println("Gratuluji dohral jsi pexeso");
    }

    public static int getRandomIndex(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return rnd;
    }

    static String convert(int code) {
        String mezi = "";
        switch (code) {
            case 1:
                mezi = "\uD83C\uDF4E";
                break;
            case 2:
                mezi = "\uD83C\uDF4C";
                break;
            case 3:
                mezi = "\uD83C\uDF50";
                break;
            case 4:
                mezi = "\uD83C\uDF52";
                break;
            case 5:
                mezi = "\uD83C\uDF53";
                break;
            case 6:
                mezi = "\uD83C\uDF4A";
                break;
            case 7:
                mezi = "\uD83C\uDF49";
                break;
            case 8:
                mezi = "\uD83C\uDF4B";
                break;
            default:
                mezi = "";
                break;

        }
        return mezi;
    }

    ;

    public static void clearConsole() {
        for (int clear = 0; clear < 10; clear++) {
            System.out.println("\b");
        }
    }


    static void hraciplocha(String[][] tabule) {
        int cislaside = 1;
        System.out.println(ANSI_BLACK_BACKGROUND + "      A    B     C    D   " + ANSI_RESET);
        for (String[] ints : tabule) {
            System.out.print(ANSI_BLACK_BACKGROUND + " " + cislaside + " " + ANSI_RESET);
            cislaside++;
            for (String vypis : ints) {
                System.out.print(ANSI_BLUE_BACKGROUND + "  " + vypis + "  " + ANSI_RESET);
            }
            System.out.println();
        }
    }

    static int[] safeSken(String[][] pole) {
        Scanner sken = new Scanner(System.in);
        int[] pls = new int[2];
        int fix = 0;

        char[] sloupce = {
                '1', '2', '3', '4'
        };

        char[] radky = {
                'A', 'B', 'C', 'D'
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
            } catch (Exception e) {
                fix = 0;
                System.out.println("Zadal jsi neplatné souřadnice." + " Zkus to znovu.");
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

                if (pole[pls[1]][pls[0]] == "❓") {
                    return pls;
                } else {
                    System.out.println("Tato karticka je uz otocena");
                    fix = 0;
                }

            } else {
                fix = 0;
                System.out.println("Zadal jsi neplatné souřadnice." + " Zkus to znovu.");
            }
        }
    }
}

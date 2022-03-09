package com.company;

import java.util.*;

public class Karty {

    public static final String RED_BRIGHT = "\033[0;91m";
    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String RESET = "\033[0m";

    public static void main(String[] args) throws InterruptedException {

        boolean end = false;

        ArrayList<String> balicek = new ArrayList<>();
        balicek.add("\uD83C\uDCCF");
        balicek.add("\uD83C\uDCCF");
        balicek.add("\uD83C\uDCCF");
        balicek.add("\uD83C\uDCCF");
        balicek.add("\uD83C\uDCA1");
        balicek.add("\uD83C\uDCA2");
        balicek.add("\uD83C\uDCA3");
        balicek.add("\uD83C\uDCA4");
        balicek.add("\uD83C\uDCA5");
        balicek.add("\uD83C\uDCA6");
        balicek.add("\uD83C\uDCA7");
        balicek.add("\uD83C\uDCA8");
        balicek.add("\uD83C\uDCA9");
        balicek.add("\uD83C\uDCAA");
        balicek.add("\uD83C\uDCAB");
        balicek.add("\uD83C\uDCAD");
        balicek.add("\uD83C\uDCAE");

        System.out.println("Pro zvoleni karty napis " + GREEN_BRIGHT + "get" + RESET + " a pro ukonceni programu napis " + RED_BRIGHT + "end" + RESET);
        System.out.println("Balicek obsahuje nasledovny pocet karet :");
        print(balicek, "\uD83C\uDCA1");
        int pocetpokusu = 0;

        while ( balicek.contains("\uD83C\uDCCF")) {
            String vstup = safeString();
            if (vstup.equals("end")) {
                end = true;
                break;
            }
            int random = (int) (Math.random() * balicek.size());
            String karta = balicek.get(random);
            String jmenokarty = getCharacterName(karta);
            System.out.println("Vytahl jsi : " + balicek.get(random) + " " + jmenokarty);
            balicek.remove(random);

            if (karta.equals("\uD83C\uDCCF")) {
                printzolik(balicek, "\uD83C\uDCA1");
            }
            else {
                print(balicek,"\uD83C\uDCA1");
            }
            pocetpokusu++;

        }
        if (end) {
            System.out.println("Ukoncil jsi program");
        }
        else {
            System.out.println();
            System.out.println("Vytahl jsi vsechny zoliky");
            System.out.println("Vytahnou vsechy zoliky ti trvalo " + pocetpokusu + " pokusu");
        }


    }

    static int safeSken() {
        Scanner sken = new Scanner(System.in);
        int a = 0;


        while (true) {
            try {
                a = sken.nextInt();
                a--;
                if (a != 0) {
                    System.out.println("Povolený input je 1. Zkus to znovu.");
                    continue;
                }
                return a;
            } catch (Exception e) {
                sken.nextLine();
                System.out.println("Zadal jsi String, double, nebo příliš velké číslo. Zkus to znovu.");
            }
        }

    }

    static String safeString() {
        Scanner sken = new Scanner(System.in);
        String a = "";

        while (true) {
            try {
                a = sken.nextLine();
                if (!(a.equals("get")) && !(a.equals("end"))  ) {
                    System.out.println("Povolený input je " + "\"get\". Zkus to znovu.");
                    continue;
                }
                return a;
            } catch (Exception e) {
                sken.nextLine();
                System.out.println("Zadal jsi int, double, nebo příliš velké číslo. Zkus to znovu.");
            }
        }

        }


    static int searchArrayFor(ArrayList<String> list, String character) {
        int count = 0;

        for (String obj : list) {
            if (obj.equals(character)) {
                count++;
            }
        }

        return count;
    }

    static double getProbability(ArrayList<String> list, String character) {
        double probability = 0;

        int all = list.size();
        int calculated = searchArrayFor(list, character);

        probability = (double) calculated / (double) all;

        return probability;
    }

    static void print(ArrayList<String> list, String character) {
        int pocetvse = list.size();
        int pocetzol = searchArrayFor(list, character);
        int probability = (int) (getProbability(list, character) * 100);
        System.out.println("Pocet es v baliku : " + pocetzol);
        System.out.println("Pocet karet v baliku : " + pocetvse);
        System.out.println("Pravepodobnost ze si vytahnes eso jako dalsi kartu : " + probability + " %");
    }
    static void printzolik(ArrayList<String> list, String character) {
        int pocetvse = list.size();
        int pocetzol = searchArrayFor(list, character);
        int probability = (int) (getProbability(list, character) * 100);
        System.out.println("Pocet es v baliku : " + pocetzol);
        System.out.println("Pocet karet v baliku : " + pocetvse);
    }

    static String getCharacterName(String character) {

        switch (character) {

            case "\uD83C\uDCCF":
                return "Zolika";

            case "\uD83C\uDCA1":
                return "Srcovy eso";

            case "\uD83C\uDCA2":
                return "Srcovou dvojku";

            case "\uD83C\uDCA3":
                return "Srcovou trojku";

            case "\uD83C\uDCA4":
                return "Srcovou ctirku";

            case "\uD83C\uDCA5":
                return "Srcovou petku";

            case "\uD83C\uDCA6":
                return "Srcovou sestku";

            case "\uD83C\uDCA7":
                return "Srcovou sedmicku";

            case "\uD83C\uDCA8":
                return "Srcovou osmicku";

            case "\uD83C\uDCA9":
                return "Srcovou devitku";

            case "\uD83C\uDCAA":
                return "Srcovou desitku";

            case "\uD83C\uDCAB":
                return "Srcovyho janeka";

            case "\uD83C\uDCAD":
                return "Srcovou kralovnu";

            case "\uD83C\uDCAE":
                return "Srcovyho krale";

            default:
                return "";

        }
    }
}

package com.company;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Indsættelse af variabler
        int max, min, runde, p1Point, p2Point;
        String player1, player2;

        //Variablernes værdier bestemmes
        p1Point=0;
        p2Point=0;
        max=6;
        min=1;
        runde = 1;

        System.out.println("Velkommen til terning spillet, indtast hver jeres navn og tryk enter!");

        //Importerer en scanner og sætter spillernes navn ud fra scannerens input
        Scanner scan = new Scanner(System.in);
        player1 = scan.nextLine();
        player2 = scan.nextLine();

        for (int i = 0; i < 5; i++) {
            int []slag = terningKast();
            int total = slag[0] + slag[1];
            System.out.println(slag[0]+ " " + slag[1] + " " + total);
        }
    }

        //Terningkast der returnerer en array af begge kast
        static int[] terningKast() {
            int diceRollOne, diceRollTwo;
            int[] diceHits;
            Random rand = new Random();
            diceRollOne = rand.nextInt(6) + 1;
            diceRollTwo = rand.nextInt(6) + 1;
            diceHits = new int[] {diceRollOne, diceRollTwo};
            return diceHits;
        }
    }


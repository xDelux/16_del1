package com.company;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Indsættelse af variabler
        int max, min, runde, diceRollOne, diceRollTwo, totalDice, p1Point, p2Point;
        String player1, player2;

        System.out.println("Velkommen til terning spillet, indtast hver jeres navn og tryk enter!");

        //Importerer en scanner og sætter spillernes navn ud fra scannerens input
        Scanner scan = new Scanner(System.in);
        player1 = scan.nextLine();
        player2 = scan.nextLine();

        //Variablernes værdier bestemmes
        p1Point=0;
        p2Point=0;
        max=6;
        min=1;
        runde = 0;


    }
}

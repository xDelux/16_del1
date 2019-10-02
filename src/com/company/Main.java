package com.company;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Indsættelse af variabler
        int max, min, runde;
        String player1, player2;

        //Variablernes værdier bestemmes
        max=6;
        min=1;
        runde = 1;

        System.out.println("Velkommen til terning spillet, indtast hver jeres navn og tryk enter!");

        //Importerer en scanner og sætter spillernes navn ud fra scannerens input
        Scanner scan = new Scanner(System.in);
        player1 = scan.nextLine();
        player2 = scan.nextLine();

        /*
        for (int i = 0; i < 5; i++) {
            int[] dice = diceThrow();
            int total = dice[0] + dice[1];
            System.out.println(dice[0]+ " " + dice[1] + " " + total);
        }
         */
        int p1Point = 0;
        boolean p2turn, p1turn, p1WinCondition, p2WinCondition;
        p1turn = true;
        p1WinCondition = false;
        int[] dice;
        //int[] dice = diceThrow();
        while (p1turn == true) {
            dice = new int[] {6,6};
            //dice = diceThrow();
            if (dice[0] == dice[1] && dice[0] != 6 && dice[1] != 6 && dice[0] != 1 && dice[1] != 1) {
                System.out.println("Du slog " + dice[0] + " og " + dice[1]);
                System.out.println("To ens slå igen!");
                p1Point += p1Point + dice[0] + dice[1];
                p1turn = true;
                p1WinCondition = false;
                System.out.println("Du har nu " + p1Point + " point!");
            }
            else if (dice[0] == 6 && dice[1] == 6) {
                System.out.println("Du slog " + dice[0] + " og " + dice[1]);
                if (p1WinCondition == true) {
                    int vundet = 1;
                    System.out.println(player1 + " har vundet!!");
                    break;
                }
                System.out.println("To 6'ere! Slå igen og hvis du slår to 6'ere denne eller næste tur igen, så er sejren din!");
                p1turn = true;

                p1WinCondition = true;
                p1Point = p1Point + dice[0] + dice[1];
                System.out.println("Du har nu " + p1Point + " point!");
            }
            else if (dice[0] == 1 && dice[1] == 1) {
                System.out.println("Du slog " + dice[0] + " og " + dice[1]);
                System.out.println("Av! Du slog to 1'ere, der røg alle dine point...");
                p1Point = 0;
                p1turn = false;
                p1WinCondition = false;
                System.out.println("Du har nu " + p1Point + " point!");
            }

            else {
                System.out.println("Du slog " + dice[0] + " og " + dice[1]);
                p1Point = p1Point + dice[0] + dice[1];
                p1turn = false;
                p1WinCondition = false;
                System.out.println("Du har nu " + p1Point + " point!");
            }
        }
    }
        //Terningkast der returnerer en array af begge kast
        static int[] diceThrow() {
            int diceRollOne, diceRollTwo;
            int[] diceHits;
            Random rand = new Random();
            diceRollOne = rand.nextInt(6) + 1;
            diceRollTwo = rand.nextInt(6) + 1;
            diceHits = new int[] {diceRollOne, diceRollTwo};
            return diceHits;
        }

    }



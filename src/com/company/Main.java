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
        int p2Point = 0;
        boolean p2turn, p1turn, p1WinCondition, p2WinCondition, gameRun;
        p1turn = true;
        p2turn = false;
        gameRun = true;
        p1WinCondition = false;
        p2WinCondition = false;
        int[] dice;
        //int[] dice = diceThrow();
        while (gameRun == true) {
            //Spiller 1
            while (p1turn == true) {
                dice = diceThrow();
                if (p1Point > 40 && dice[0] == dice[1]) {
                    System.out.println(player1 + " slog " + dice[0] + " og " + dice[1]);
                    System.out.println(player1 + " vandt!");
                    break;
                }
                else if (dice[0] == dice[1] && dice[0] != 6 && dice[1] != 6 && dice[0] != 1 && dice[1] != 1) {
                    System.out.println(player1 + " slog " + dice[0] + " og " + dice[1]);
                    System.out.println("To ens slå igen!");
                    p1Point += p1Point + dice[0] + dice[1];
                    p1turn = true;
                    p1WinCondition = false;
                    System.out.println(player1 + " har nu " + p1Point + " point!");
                }
                else if (dice[0] == 6 && dice[1] == 6) {
                    System.out.println(player1 + " slog " + dice[0] + " og " + dice[1]);
                    if (p1WinCondition == true) {
                        System.out.println(player1 + " har vundet!!");
                        break;
                    }
                    System.out.println("To 6'ere! Slå igen og hvis du slår to 6'ere denne eller næste tur igen, så er sejren din!");
                    p1turn = true;
                    p1WinCondition = true;
                    p1Point = p1Point + dice[0] + dice[1];
                    System.out.println(player1 + " har nu " + p1Point + " point!");
                }
                else if (dice[0] == 1 && dice[1] == 1) {
                    System.out.println(player1 + " slog " + dice[0] + " og " + dice[1]);
                    System.out.println("Av! Du slog to 1'ere, der røg alle dine point...");
                    p1Point = 0;
                    p1turn = false;
                    p2turn = true;
                    p1WinCondition = false;
                    System.out.println(player1 + " har nu " + p1Point + " point!");
                }

                else {
                    System.out.println(player1 + " slog " + dice[0] + " og " + dice[1]);
                    p1Point = p1Point + dice[0] + dice[1];
                    p1turn = false;
                    p2turn = true;
                    p1WinCondition = false;
                    System.out.println(player1 + " har nu " + p1Point + " point!");
                }
                //Spiller 2
                while (p2turn == true) {
                    dice = diceThrow();
                    if (p2Point > 40 && dice[0] == dice[1]) {
                        System.out.println(player2 + " slog " + dice[0] + " og " + dice[1]);
                        System.out.println(player2 + " vandt!");
                        break;
                    }
                    else if (dice[0] == dice[1] && dice[0] != 6 && dice[1] != 6 && dice[0] != 1 && dice[1] != 1) {
                        System.out.println(player2 + " slog " + dice[0] + " og " + dice[1]);
                        System.out.println("To ens slå igen!");
                        p2Point += p2Point + dice[0] + dice[1];
                        p2turn = true;
                        p2WinCondition = false;
                        System.out.println(player2 + " har nu " + p2Point + " point!");
                    }
                    else if (dice[0] == 6 && dice[1] == 6) {
                        System.out.println(player2 + " slog " + dice[0] + " og " + dice[1]);
                        if (p2WinCondition == true) {
                            System.out.println(player2 + " har vundet!!");
                            break;
                        }
                        System.out.println("To 6'ere! Slå igen og hvis du slår to 6'ere denne eller næste tur igen, så er sejren din!");
                        p2turn = true;

                        p2WinCondition = true;
                        p2Point = p2Point + dice[0] + dice[1];
                        System.out.println(player2 + " har nu " + p2Point + " point!");
                    }
                    else if (dice[0] == 1 && dice[1] == 1) {
                        System.out.println(player2 + " slog " + dice[0] + " og " + dice[1]);
                        System.out.println("Av! Du slog to 1'ere, der røg alle dine point...");
                        p2Point = 0;
                        p2turn = false;
                        p1turn = true;
                        p2WinCondition = false;
                        System.out.println(player2 + " har nu " + p2Point + " point!");
                    }

                    else {
                        System.out.println(player2 + " slog " + dice[0] + " og " + dice[1]);
                        p2Point = p2Point + dice[0] + dice[1];
                        p2turn = false;
                        p1turn = true;
                        p2WinCondition = false;
                        System.out.println(player2 + " har nu " + p2Point + " point!");
                    }
                }
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




package com.company;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Main {

    private static void main(String[] args) {
        //Indsættelse af variabler
        int p1Point, p2Point;
        boolean p2turn, p1turn, p1WinCondition, p2WinCondition, gameRun;
        int[] dice;
        String player1, player2;

        //Variablernes værdier bestemmes
        //Integers
        p1Point = 0;
        p2Point = 0;
        //Booleans
        p1turn = true;
        p2turn = false;
        gameRun = true;
        p1WinCondition = false;
        p2WinCondition = false;

        System.out.println("Velkommen til terning spillet, indtast hver jeres navn og tryk enter!");
        //Importerer en scanner og sætter spillernes navn ud fra scannerens input
        Scanner scan = new Scanner(System.in);
        player1 = scan.nextLine();
        player2 = scan.nextLine();

        //Spilstart, når gameRun er lig med sand skal dette loop køre.
        while (gameRun == true) {
                //Spiller 1's tur hele loopet består af hvilke scenarier slaget kan gå igennem.
                //Turen bestemmes når p1Turn eller p2Turn er sandt eller falsk, de bliver bestemt efter hvert slag.
                while (p1turn == true) {
                    //En kommando der venter på et tomt input i denne sag skal man bare trykke enter.
                    System.out.println(player1 + "'s tur! Tryk Enter for næste slag!");
                    try {System.in.read();}
                    catch(Exception e) {}
                    //Sætter int arrayet dice til metoden diceThrow der retunerer et int array af de to terninger
                    dice = diceThrow();
                    /*Hvis spilleren har mere eller lig med 40 point og slår to ens terninger undtagen hvis de to ens er 1,
                    så vinder spiller 1*/
                    if (p1Point >= 40 && dice[0] == dice[1] && dice[0] != 1 && dice[1] != 1) {
                        System.out.println(player1 + " slog " + dice[0] + " og " + dice[1]);
                        System.out.println(player1 + " vandt!");
                        System.out.println("-----------------------");
                        /*Indæstter ny scanner der modtager et input hvis det er j eller n så genstarter eller slutter spillet henholdvis til
                        svaret*/
                        System.out.println("Vil " + player2 + " have revanche? ;^) (j eller n)");
                        Scanner input2 = new Scanner(System.in);
                        String genstart = input2.nextLine();
                        if (genstart.equals("j")) {
                            p1Point = 0;
                            p2Point = 0;
                            p1turn = true;
                            p2turn = false;
                            System.out.println("Nyt spil startes!");
                            System.out.println(" ");
                        }
                        else {
                            System.out.println("Tak for spillet :^)");
                            gameRun = false;
                            break;
                        }
                        }
                    //Hvis at terningerne er ens undtaget 6'ere og 1'ere. Så får spilleren en tur til og point til sin score
                    else if (dice[0] == dice[1] && dice[0] != 6 && dice[1] != 6 && dice[0] != 1 && dice[1] != 1) {
                        System.out.println(player1 + " slog " + dice[0] + " og " + dice[1]);
                        System.out.println("To ens slå igen!");
                        p1turn = true;
                        p1WinCondition = false;
                        p1Point = p1Point + dice[0] + dice[1];
                        System.out.println(player1 + " har nu " + p1Point + " point!");
                        System.out.println(" ");
                        }
                    //Hvis begge terninger er 6 så tilføj point til score og sæt vindMedTo6'ere til sandt
                    //Hvilket gør så hvis spilleren slår 2 6'ere i samme tur eller næste tur, så vinder spilleren.
                    //Igen efterfølgles det med et scanner der kan restart eller slutte spillet.
                    else if (dice[0] == 6 && dice[1] == 6) {
                        System.out.println(player1 + " slog " + dice[0] + " og " + dice[1]);
                        if (p1WinCondition == true) {
                            System.out.println(player1 + " har vundet!!");
                            System.out.println("-----------------------");
                            System.out.println("Vil " + player2 + " have revanche? ;^) (j eller n)");
                            Scanner input2 = new Scanner(System.in);
                            String genstart = input2.nextLine();
                            //Nyt spil startes
                            if (genstart.equals("j")) {
                                p1Point = 0;
                                p2Point = 0;
                                p1turn = true;
                                p2turn = false;
                                System.out.println("Nyt spil startes!");
                                System.out.println(" ");
                            }
                            //Spil sluttes
                            else {
                                System.out.println("Tak for spillet :^)");
                                gameRun = false;
                                break;
                            }
                        }
                        System.out.println("To 6'ere! Slå igen og hvis du slår to 6'ere denne eller næste tur igen, så er sejren din!");
                        p1turn = true;
                        p1WinCondition = true;
                        p1Point = p1Point + dice[0] + dice[1];
                        System.out.println(player1 + " har nu " + p1Point + " point!");
                        System.out.println(" ");
                        }
                    //Hvis spilleren slår to 1'ere så mister de alle deres point og det bliver sat til nul.
                    else if (dice[0] == 1 && dice[1] == 1) {
                        System.out.println(player1 + " slog " + dice[0] + " og " + dice[1]);
                        System.out.println("Av! Du slog to 1'ere, der røg alle dine point...");
                        p1turn = false;
                        p2turn = true;
                        p1WinCondition = false;
                        p1Point = 0;
                        System.out.println(player1 + " har nu " + p1Point + " point!");
                        System.out.println(" ");
                        }
                    //Til sidst hvis spilleren slår et normal slag bliver slaget vist i konsollen
                    //og tilføjet til spillerenspoint
                    else {
                        System.out.println(player1 + " slog " + dice[0] + " og " + dice[1]);
                        p1turn = false;
                        p2turn = true;
                        p1WinCondition = false;
                        p1Point = p1Point + dice[0] + dice[1];
                        System.out.println(player1 + " har nu " + p1Point + " point!");
                        System.out.println(" ");
                    }
                    //Herunder er det den samme kode for spiller 1, men bare for spiller 2.
                    while (p2turn == true) {
                        System.out.println(player2 + "'s tur! Tryk Enter for næste slag!");
                        try {System.in.read();}
                        catch(Exception e) {}

                        dice = diceThrow();
                        if (p2Point >= 40 && dice[0] == dice[1] && dice[0] != 1 && dice[1] != 1) {
                            System.out.println(player2 + " slog " + dice[0] + " og " + dice[1]);
                            System.out.println(player2 + " vandt!");
                            System.out.println("-----------------------");
                            System.out.println("Vil " + player1 + " have revanche? ;^) (j eller n)");
                            Scanner input2 = new Scanner(System.in);
                            String genstart = input2.nextLine();
                            if (genstart.equals("j")) {
                                p1Point = 0;
                                p2Point = 0;
                                p1turn = true;
                                p2turn = false;
                                System.out.println("Nyt spil startes!");
                                System.out.println(" ");
                            }
                            else {
                                System.out.println("Tak for spillet :^)");
                                gameRun = false;
                                break;
                            }
                        }

                        else if (dice[0] == dice[1] && dice[0] != 6 && dice[1] != 6 && dice[0] != 1 && dice[1] != 1) {
                            System.out.println(player2 + " slog " + dice[0] + " og " + dice[1]);
                            System.out.println("To ens slå igen!");
                            p2turn = true;
                            p2WinCondition = false;
                            p2Point = p2Point + dice[0] + dice[1];
                            System.out.println(player2 + " har nu " + p2Point + " point!");
                            System.out.println(" ");
                            }

                        else if (dice[0] == 6 && dice[1] == 6) {
                            System.out.println(player2 + " slog " + dice[0] + " og " + dice[1]);
                                if (p2WinCondition == true) {
                                    System.out.println(player2 + " har vundet!!");
                                    System.out.println("-----------------------");
                                    System.out.println("Vil " + player1 + " have revanche? ;^) (j eller n)");
                                    Scanner input2 = new Scanner(System.in);
                                    String genstart = input2.nextLine();
                                    if (genstart.equals("j")) {
                                        p1Point = 0;
                                        p2Point = 0;
                                        p1turn = true;
                                        p2turn = false;
                                        System.out.println("Nyt spil startes!");
                                        System.out.println(" ");
                                    }
                                    else {
                                        System.out.println("Tak for spillet :^)");
                                        gameRun = false;
                                        break;
                                    }
                                }
                            System.out.println("To 6'ere! Slå igen og hvis du slår to 6'ere denne eller næste tur igen, så er sejren din!");
                            p2turn = true;
                            p2WinCondition = true;
                            p2Point = p2Point + dice[0] + dice[1];
                            System.out.println(player2 + " har nu " + p2Point + " point!");
                            System.out.println(" ");
                        }

                        else if (dice[0] == 1 && dice[1] == 1) {
                            System.out.println(player2 + " slog " + dice[0] + " og " + dice[1]);
                            System.out.println("Av! Du slog to 1'ere, der røg alle dine point...");
                            p2turn = false;
                            p1turn = true;
                            p2WinCondition = false;
                            p2Point = 0;
                            System.out.println(player2 + " har nu " + p2Point + " point!");
                            System.out.println(" ");
                        }

                        else {
                            System.out.println(player2 + " slog " + dice[0] + " og " + dice[1]);
                            p2turn = false;
                            p1turn = true;
                            p2WinCondition = false;
                            p2Point = p2Point + dice[0] + dice[1];
                            System.out.println(player2 + " har nu " + p2Point + " point!");
                            System.out.println(" ");
                        }
                    }
                }
            }
        }

        //Terningkast der returnerer en array af begge kast
        static int[] diceThrow() {
            //Variabler bestemmes
            int diceRollOne, diceRollTwo;
            //Array bestemmes
            int[] diceHits;
            //Tilfædigt tal bliver sat til de to diceRoll variabler.
            Random rand = new Random();
            diceRollOne = rand.nextInt(6) + 1;
            diceRollTwo = rand.nextInt(6) + 1;
            //rand bliver sat til 6 det vælger et tal til 6, dermed fra 0 - 5. Så plus 1 til sidst
            //så det bliver et tal fra 1-6, som en terning.
            //Terningevariablerne bliver sat ind i arrayet diceHits.
            diceHits = new int[] {diceRollOne, diceRollTwo};
            //Returerer diceHits.
            return diceHits;
        }

    }




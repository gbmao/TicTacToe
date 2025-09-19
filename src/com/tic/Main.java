package com.tic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        game();

    }


    public static boolean checkVictory(String[][] game, String player) {

        //check horizontal
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (game[i][j].equals(player)) {
                    count++;
                }
            }
            if (count == 3) return true;
        }

        //check vertical
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (game[j][i].equals(player)) {
                    count++;
                }
            }
            if (count == 3) return true;
        }

        //check diagonal
        int count = 0;
        for (int i = 0, j = 2; i < 3; i++, j--) {

            if (game[j][i].equals(player)) {
                count++;

            }
            if (count == 3) return true;
        }

        count = 0;
        for (int i = 0; i < 3; i++) {

            if (game[i][i].equals(player)) {
                count++;

            }
            if (count == 3) return true;
        }
        return false;

    }

    public static boolean avoidEnemyVictory(String[][] menu, String[][] game, String player, String pc) {

        boolean victory = false;
        //check horizontal
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (game[i][j].equals(player)) {
                    count++;

                    // mark


                }
                    if(victory && game[i][j].equals(" ")){
                        game[i][j] = pc;
                        menu[i][j] = pc;
                        System.out.println("marquei hori linha : " + i + " coluna: " +j ); // retirar depois
                        return true;
                    }

                    if (count == 2 && !victory) {
                        j = -1;
                        victory = true;
                    }
            }
        }

        //check vertical
        victory = false;
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (game[j][i].equals(player)) {
                    count++;
                }
                if(victory && game[j][i].equals(" ")){
                    game[j][i] = pc;
                    menu[j][i] = pc;
                    System.out.println("marquei verti linha : " + i + " coluna: " +j ); // retirar depois
                    return true;
                }

                if (count == 2 && !victory) {
                    j = -1;
                    victory = true;
                }

            }
        }

        //check diagonal
        victory = false;
        int count = 0;
        for (int i = 0, j = 2; i < 3; i++, j--) {

            if (game[j][i].equals(player)) {
                count++;

            }
            if(victory && game[j][i].equals(" ")){
                game[j][i] = pc;
                menu[j][i] = pc;
                System.out.println("marquei ali linha : " + i + " coluna: " +j ); // retirar depois
                return true;
            }

            if (count == 2 && !victory) {
                j = 3;
                i = -1;
                victory = true;
            }

        }

        count = 0;
        victory = false;
        for (int i = 0; i < 3; i++) {

            if (game[i][i].equals(player)) {
                count++;

            }
            if(victory && game[i][i].equals(" ")){
                game[i][i] = pc;
                menu[i][i] = pc;
                System.out.println("marquei aqui linha : " + i + " coluna: " +i); // retirar depois
                return true;
            }

            if (count == 2 && !victory) {
                i = -1;
                victory = true;
            }

        }
        return false;

    }

    public static boolean markTicTacToe(String[][] menu, String response, String[][] game, String player) {
        for (int i = 0; i < menu.length; i++) {

            for (int j = 0; j < menu[i].length; j++) {
                if (menu[i][j].equalsIgnoreCase(response)) {

                    if (game[i][j].equals(" ")) {
//                        menu[i][j] = player;
                        game[i][j] = player;
                        return false; // false == exit from while loop
                    } else {
                        System.out.println(response + " Ja esta marcado!");
                        return true;
                    }

                }
            }

        }
        return true;
    }


    public static void printTicTacToe(String[][] game) {

        for (int i = 0; i < game.length; i++) {

            for (int j = 0; j < game[i].length; j++) {
                if (j == game[i].length - 1) {

                    System.out.print(game[i][j]);
                } else {
                    System.out.print(game[i][j] + "|");
                }
            }
            System.out.println();
            if (i != game.length - 1) {
                System.out.println("-".repeat(6));
            }
        }

    }

    public static void menuRules(String[][] menu) {

        printTicTacToe(menu);
        System.out.println("-".repeat(30));
        System.out.println("Escolha um numero para marca-lo");
        System.out.println("Tente marcar uma linha de 3");
        System.out.println("Nao deixe seu oponente marcar uma linha de 3");
        System.out.println("-Digite qualquer tecla para mostrar esse menu novamente");
        System.out.println("-aperte Enter para continuar a jogar");
        System.out.println("-".repeat(30));
    }

    public static void play(String player, String[][] game, String[][] menu, Scanner scanner) {
        boolean flag = true;
        while (flag) {
            printTicTacToe(game);
            System.out.println("-".repeat(10));

            System.out.print("Escolha um numero:");

            try {
                String response = scanner.nextLine();
                int res = Integer.parseInt(response);
                if (res < 1 || res > 9) {
                    System.out.println("Digite um numero valido");
                    menuRules(menu);
                    scanner.nextLine();
                } else {

                    flag = markTicTacToe(menu, response, game, player);

                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero válido");
                menuRules(menu);
                scanner.nextLine();
            }

        }
    }

    public static void game() {
        String[][] game = {{" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};

        String[][] menu = {{"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}};


        Scanner scanner = new Scanner(System.in);
        String player = "X";
        String player2 = "0";
        menuRules(menu);
        boolean winner = false;
        int playCount = 0;
        while (!winner) {
            play(player, game, menu, scanner);
            winner = checkVictory(game, player);
            playCount++;
            if (winner) {
                System.out.println("player 1: " + player + " won");
                printTicTacToe(game);
                continue;
            }
            if (playCount == 9) {
                System.out.println("Draw");
                printTicTacToe(game);
                winner = true;
                continue;
            }

            if(!avoidEnemyVictory(menu,game,player, player2)) {

            play(player2, game, menu, scanner);
            }
            winner = checkVictory(game, player2);
            if (winner) {
                System.out.println("player 2: " + player2 + " won");
                printTicTacToe(game);

            }
            playCount++;
        }

    }


}
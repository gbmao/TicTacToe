package com.tic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        game();

    }

    public static boolean ticTacToe(String[][] menu, String response, String[][] game, String player) {
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


    public static void ticTacToe(String[][] game) {

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

        ticTacToe(menu);
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
            ticTacToe(game);
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

                    flag = ticTacToe(menu, response, game, player);

                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido");
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
        boolean noWinners = true;
        while (noWinners) {
            play(player, game, menu, scanner);
            play(player2, game, menu, scanner);
        }
    }


}
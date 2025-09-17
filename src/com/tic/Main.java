package com.tic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] game = {{" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}};

        String[][] menu = {{"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}};

        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        String player = "X";
        String player2 = "0";

        menuRules(menu);
//        scanner.nextLine();

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
                    boolean notMarked = true;

                    ticTacToe(menu, response, game, player);

                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido");
                menuRules(menu);
                scanner.nextLine();
            }

        }
    }

    public static void ticTacToe(String[][] menu, String response, String[][] game, String player) {
        for (int i = 0; i < menu.length; i++) {

            for (int j = 0; j < menu[i].length; j++) {
                if (menu[i][j].equalsIgnoreCase(response)) {

                    if (game[i][j].equals(" ")) {
//                        menu[i][j] = player;
                        game[i][j] = player;

                    } else {
                        System.out.println(response + " Ja esta marcado!");

                    }

                }
            }

        }

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


}
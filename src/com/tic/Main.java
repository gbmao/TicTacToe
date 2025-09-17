package com.tic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] game = {{" "," "," "},
                {" "," "," "},
                {" "," "," "}};

        String[][] menu = {{"1","2","3"},
                {"4","5","6"},
                {"7","8","9"}};

        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        String player = "X";
        while(flag) {
            ticTacToe(game);
            System.out.println("-".repeat(10));
            ticTacToe(menu);
            System.out.print("Escolha um numero:");

            try {
                String response = scanner.nextLine();
                int res = Integer.parseInt(response);
                if(res <1 || res > 9) {
                    System.out.println("Digite um numero valido");
                } else {
                ticTacToe(menu, response, game, player);
    //            flag = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido");
            }

        }
    }

    public static void ticTacToe(String[][] menu,String response, String[][] game, String player){
        for (int i = 0; i < menu.length; i++) {

            for (int j = 0; j < menu[i].length; j++) {
                if(menu[i][j].equalsIgnoreCase(response)) {

                    menu[i][j] = player;
                    game[i][j] = player;

                }
            }

        }

    }


    public static void ticTacToe(String[][] game) {

        for (int i = 0; i < game.length; i++) {

            for (int j = 0; j < game[i].length; j++) {
                if(j == game[i].length -1) {

                System.out.print(game[i][j]);
                } else {
                    System.out.print(game[i][j] + "|");
                }
            }
            System.out.println();
            if(i != game.length -1) {
                System.out.println("-".repeat(6));
            }
        }

    }
}
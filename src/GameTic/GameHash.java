package GameTic;

import java.util.Objects;
import java.util.Scanner;

public class GameHash {
    public static char [][] game = new char[3][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean win = false;
        int move = 1;
        char signal;
        char val;
        int line = 0, column = 0;

        System.out.println(" -------- TIC TAC TOE.GAME --------");
        do{
            while (!win) {  // Enquanto não houver vencedor faça isso
                if (move % 2 == 1) {
                    System.out.println("Player 1  ---- [X]");
                    signal = 'X';
                } else {
                    System.out.println("Player 2  ---- [O]");
                    signal = 'O';
                }

                boolean validLine = false;
                while (!validLine) {           // Enquanto a linha estiver válida (vazia) faça isso
                    System.out.print("Choosing number to line [1, 2, 3]: ");
                    line = sc.nextInt();
                    if (line >= 1 && line <= 3) {
                        validLine = true;
                    } else {
                        System.out.println("Invalid Line number ! ");
                    }

                    boolean validColumn = false;
                    while (!validColumn) {    // Enquanto a coluna estiver válida (vazia) faça isso
                        System.out.print("Choosing number to column [1, 2, 3]: ");
                        column = sc.nextInt();
                        if (column >= 1 && column <= 3) {
                            validColumn = true;
                        } else {
                            System.out.println("Invalid Column number ! ");
                        }
                    }

                    line--;
                    column--;
                    if (game[line][column] == 'X' || game[line][column] == 'O') {
                        System.out.println("\u001b[31mOccupied position !\u001b[0m");
                    } else {
                        game[line][column] = signal;
                        move++;
                    }

                    for (int i = 0; i < game.length; i++) {
                        for (int j = 0; j < game[i].length; j++) {
                            System.out.print(game[i][j] + " | ");
                        }
                        System.out.println();
                    }


                    if ((game[0][0] == 'X' && game[0][1] == 'X' && game[0][2] == 'X') || // l1
                            (game[1][0] == 'X' && game[1][1] == 'X' && game[1][2] == 'X') || // l2
                            (game[2][0] == 'X' && game[2][1] == 'X' && game[2][2] == 'X') || // l3
                            (game[0][0] == 'X' && game[1][0] == 'X' && game[2][0] == 'X') || // c1
                            (game[0][1] == 'X' && game[1][1] == 'X' && game[2][1] == 'X') || // c2
                            (game[0][2] == 'X' && game[1][2] == 'X' && game[2][2] == 'X') || // c3
                            (game[0][0] == 'X' && game[1][1] == 'X' && game[2][2] == 'X')  // Diagonal
                    ) {
                        win = true;
                        System.out.println("Player 1 WIN !!!!!");

                    } else if ((game[0][0] == 'O' && game[0][1] == 'O' && game[0][2] == 'O') || // l1
                            (game[1][0] == 'O' && game[1][1] == 'O' && game[1][2] == 'O') || // l2
                            (game[2][0] == 'O' && game[2][1] == 'O' && game[2][2] == 'O') || // l3
                            (game[0][0] == 'O' && game[1][0] == 'O' && game[2][0] == 'O') || // c1
                            (game[0][1] == 'O' && game[1][1] == 'O' && game[2][1] == 'O') || // c2
                            (game[0][2] == 'O' && game[1][2] == 'O' && game[2][2] == 'O') || // c3
                            (game[0][0] == 'O' && game[1][1] == 'O' && game[2][2] == 'O')) {  // Diagonal
                        win = true;
                        System.out.println("Player 2 WIN !!!!!");
                    } else if (move > 9) {
                        win = true;
                        System.out.println("No one won !");
                    }
                }
            }

            System.out.print("Do you want to play again ? [y/n]: ");
            val = sc.next().charAt(0);
            if(val == 'y'){
                gameAgain();
                win = false;
                move--;
            }
        }while(Objects.equals(val, 'y'));
    }

    public static void gameAgain(){
        System.out.println();
        System.out.println(" -------- TIC TAC TOE.GAME --------");
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                game[i][j] = '\u0000';
            }
        }
    }
}



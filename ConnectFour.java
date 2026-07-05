import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[6][7];
        char player = 'X';
        boolean playAgain = true;

        while (playAgain) {

        
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    board[i][j] = '.';
                }
            }

            player = 'X';
            boolean gameOver = false;
            int moves = 0;

            while (!gameOver) {

           
                System.out.println("\nBoard:");
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 7; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.print("Player " + player + " - Enter column (1-7): ");
                int col = sc.nextInt();

             
                if (col < 1 || col > 7) {
                    System.out.println("Invalid column! Enter a number between 1 and 7.");
                    continue;
                }

                col--; 


                boolean placed = false;
                for (int row = 5; row >= 0; row--) {
                    if (board[row][col] == '.') {
                        board[row][col] = player;
                        placed = true;
                        moves++;
                        break;
                    }
                }

                if (!placed) {
                    System.out.println("Column is full! Try another column.");
                    continue;
                }

                boolean win = false;


                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (board[i][j] == player &&
                            board[i][j + 1] == player &&
                            board[i][j + 2] == player &&
                            board[i][j + 3] == player) {
                            win = true;
                        }
                    }
                }

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 7; j++) {
                        if (board[i][j] == player &&
                            board[i + 1][j] == player &&
                            board[i + 2][j] == player &&
                            board[i + 3][j] == player) {
                            win = true;
                        }
                    }
                }

            
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (board[i][j] == player &&
                            board[i + 1][j + 1] == player &&
                            board[i + 2][j + 2] == player &&
                            board[i + 3][j + 3] == player) {
                            win = true;
                        }
                    }
                }

      
                for (int i = 3; i < 6; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (board[i][j] == player &&
                            board[i - 1][j + 1] == player &&
                            board[i - 2][j + 2] == player &&
                            board[i - 3][j + 3] == player) {
                            win = true;
                        }
                    }
                }

                if (win) {
                    System.out.println("\nFinal Board:");
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print(board[i][j] + " ");
                        }
                        System.out.println();
                    }

                    System.out.println("🎉 Player " + player + " Wins!");
                    gameOver = true;
                } else if (moves == 42) {
                    System.out.println("Game Draw!");
                    gameOver = true;
                } else {
                    if (player == 'X')
                        player = 'O';
                    else
                        player = 'X';
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            char choice = sc.next().charAt(0);

            if (choice == 'y' || choice == 'Y')
                playAgain = true;
            else
                playAgain = false;
        }

        System.out.println("Thank you for playing!");
        sc.close();
    }
}
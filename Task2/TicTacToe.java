import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
            int row = -1;
            int col = -1;
            Scanner scanner = new Scanner(System.in);

            while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '\u0000') {
                System.out.print("Enter row (1-3): ");
                row = scanner.nextInt() - 1;
                System.out.print("Enter column (1-3): ");
                col = scanner.nextInt() - 1;
                if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '\u0000') {
                    System.out.println("Invalid move. Try again.");
                }
            }

            board[row][col] = currentPlayer;
            gameEnded = isGameEnd(row, col);
            if (!gameEnded) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
            
        }

        printBoard();
        if (currentPlayer == 'X') {
            System.out.println("Player O wins!");
        } else if (currentPlayer == 'O') {
            System.out.println("Player X wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '\u0000';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean isGameEnd(int row, int col) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer)
                || (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer)
                || (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
                || (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
                || isBoardFull();
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }
}

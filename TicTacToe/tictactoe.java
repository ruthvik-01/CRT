package TicTacToe;

import java.util.Scanner;

public class tictactoe {

    static char[][] board = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    static char player = 'X';
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean gameOver = false;

        System.out.println("=== TIC TAC TOE ===");

        while (!gameOver) {

            printBoard();

            System.out.print("Player " + player + ", enter row and column (1-3): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            // Validate input range
            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("❌ Invalid input! Try again.");
                continue;
            }

            // Check if cell is already taken
            if (board[row - 1][col - 1] != ' ') {
                System.out.println("❌ Cell already taken! Try again.");
                continue;
            }

            // Place move
            board[row - 1][col - 1] = player;

            // Check win
            if (checkWin()) {
                printBoard();
                System.out.println("🎉 Player " + player + " wins!");
                gameOver = true;
            }
            // Check draw
            else if (isBoardFull()) {
                printBoard();
                System.out.println("🤝 It's a draw!");
                gameOver = true;
            }
            // Switch player
            else {
                player = (player == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    // Print Board
    static void printBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check Win
    static boolean checkWin() {

        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player) {
                return true;
            }
        }

        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player &&
                    board[1][i] == player &&
                    board[2][i] == player) {
                return true;
            }
        }

        // Diagonals
        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Check Draw
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
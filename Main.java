package TikTacToe;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final char[] theBoard = new char[10];
    private static final Random rand = new Random();
    private static final Scanner scan = new Scanner(System.in);
    private static int COMPUTER_SCORE = 0;
    private static int PLAYER_SCORE = 0;

    private static void initializeBoard() {
        for (int i = 0; i < theBoard.length; i++) {
            theBoard[i] = ' ';
        }
    }

    private static void printWinner() {
        System.out.println("Computer Score: " + COMPUTER_SCORE);
        System.out.println("Player Score: " + PLAYER_SCORE);
    }

    private static void updateBoard(char[] theBoard) {
        System.out.println();
        System.out.println(theBoard[0] + "  | " + theBoard[1] + " | " + theBoard[2]);
        System.out.println("-----------");
        System.out.println(theBoard[3] + "  | " + theBoard[4] + " | " + theBoard[5]);
        System.out.println("-----------");
        System.out.println(theBoard[6] + "  | " + theBoard[7] + " | " + theBoard[8]);
    }

    private static String whoGoesFirst() {
        if (rand.nextBoolean() == true) {
            return "Player";
        }
        return "Computer";
    }
    private static void playGame() {
        String whoGoesFirst = whoGoesFirst();
        initializeBoard();
        if (whoGoesFirst.equals("Player")) {
            playerStarts();
        } else {
            computerStarts();
        }
    }

    private static void computerStarts() {
        System.out.println("\nCOMPUTER GETS TO GO FIRST! ");
        while (true) {
            computerMove('x');
            String checkWinner = checkWinner();
            if (checkWinner!= null) {
                System.out.println("\n" + checkWinner + " is the Winner!");
                if (checkWinner == "x") {
                    COMPUTER_SCORE += 1;
                } else {
                    PLAYER_SCORE += 1;
                }
                break;
            }
            playerMove('o');
        }
    }

    private static void playerStarts() {
        System.out.println("\nPLAYER GETS TO GO FIRST. MOVE(0/8)");
        while (true) {
            playerMove('x');
            String checkWinner = checkWinner();
            if (checkWinner != null) {
                System.out.println("\n" + checkWinner + " is the Winner!");
                if (checkWinner == "x") {
                    PLAYER_SCORE += 1;
                } else {
                    COMPUTER_SCORE += 1;
                }
                break;
            }
            computerMove('o');

        }
    }

    private static void playerMove(char playerChar) {
        int move = scan.nextInt();
        while (theBoard[move] != ' ') {
            System.out.println("Invalid move");
            move = scan.nextInt();
        }
        theBoard[move] = playerChar;
        updateBoard(theBoard);
    }

    private static void computerMove(char computerChar) {
        int move = rand.nextInt(10);
        while (theBoard[move] != ' ') {
            move = rand.nextInt(10);
        }
        theBoard[move] = computerChar;
        updateBoard(theBoard);
    }

    private static String checkWinner() {
        for (int i = 0; i < 8; i++) {
            String cross = null;

            switch (i) {
                case 0:
                    cross = "" + theBoard[0] + theBoard[1] + theBoard[2];
                    break;
                case 1:
                    cross = "" + theBoard[3] + theBoard[4] + theBoard[5];
                    break;
                case 2:
                    cross = "" + theBoard[6] + theBoard[7] + theBoard[8];
                    break;
                case 3:
                    cross = "" + theBoard[0] + theBoard[3] + theBoard[6];
                    break;
                case 4:
                    cross = "" + theBoard[1] + theBoard[4] + theBoard[7];
                    break;
                case 5:
                    cross = "" +theBoard[2] + theBoard[5] + theBoard[8];
                    break;
                case 6:
                    cross = "" + theBoard[0] + theBoard[4] + theBoard[8];
                    break;
                case 7:
                    cross = "" + theBoard[2] + theBoard[4] + theBoard[6];
                    break;
            }
            if (cross.equals("xxx"))  {
                return "x";
            } else if (cross.equals("ooo")) {
                return "o";
            }
        }
        for (int i = 0; i < 9; i++) {
            if(theBoard[i] == ' ') {
                break;
            } else if (i == 8 && theBoard[i] != ' ') {
                return "draw";
            }

        }
        return null;
    }

    public static void main(String[] args) {
        playGame();
        printWinner();
    }
}

import java.util.Scanner;

public class Game {

    private Board board;
    private Scanner scanner;
    private boolean gameOver;

    public Game() {
        this.board = new Board();
        this.scanner = new Scanner(System.in);
        this.gameOver = false;
    }

    public void start() {
        System.out.println("=== Minesweeper (Console) ===");
        System.out.println("Enter your move as: row column (both 0-9)");
        System.out.println("Example 3 7");

        render(false);

        while (!gameOver) {

            int row = readInt("Row (0-9) :");
            int col = readInt("Col (0-9) :");

            Board.moveResult result = board.revealCell(row, col);

            switch (result) {
                case INVALID: {
                    System.out.println("Invalid coordinates. Please enter values between 0 and 9");
                    break;
                }

                case SPOT_REVEALED_ALREADY: {

                    System.out.println("Cell revealed already. Try another one");
                    break;

                }

                case SAFE_SPOT: {

                    render(false);

                    if (board.gameWin()) {
                        System.out.println("You Win!!!");
                        gameOver = true;
                    }
                    break;

                }

                case MINE_SPOT: {
                    System.out.println("BOOM!!");
                    render(true);
                    gameOver = true;
                }
                    break;

            }

            if (!gameOver && (result == Board.moveResult.INVALID || result == Board.moveResult.SPOT_REVEALED_ALREADY)) {

                render(false);
            }

        }

        scanner.close();
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please neter a valid number");
            }
        }
    }

    private void render(boolean showMines) {

        System.out.print(" ");
        for (int c = 0; c < Board.SIZE; c++) {
            System.out.print(c + " ");
        }

        System.out.println();

        for (int r = 0; r < Board.SIZE; r++) {
            System.out.print(r + " ");

            for (int c = 0; c < Board.SIZE; c++) {
                Cell cell = board.getCell(r, c);
                System.out.print(printCell(cell, showMines) + " ");
            }

            System.out.println();

        }
        System.out.println();

    }

    private String printCell(Cell cell, boolean showMines) {
        if (cell.isCellRevealed()) {
            if (cell.isMine()) {
                return "*";
            }
            return String.valueOf(cell.getSurroundingMines());
        }

        if (showMines && cell.isMine()) {
            return "*";
        }

        return ".";

    }

}

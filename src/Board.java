public class Board {

    public static final int SIZE = 10;
    public static final int MINES = 10;

    private final Cell[][] grid;
    private int safeCellCount;

    public enum moveResult {
        INVALID, SPOT_REVEALED_ALREADY, SAFE_SPOT, MINE_SPOT
    }

    public Board() {
        this.grid = new Cell[SIZE][SIZE];
        this.safeCellCount = 0;

        createEmptyGrid();
        placeMines();
        calculateAdjacentMineCount();

    }

    private void createEmptyGrid() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                grid[r][c] = new Cell();
            }
        }
    }

    private void placeMines() {

        int minesPlaced = 0;

        while (minesPlaced < MINES) {
            int r = (int) (Math.random() * SIZE);
            int c = (int) (Math.random() * SIZE);

            if (!grid[r][c].isMine()) {
                grid[r][c].setMine(true);
                minesPlaced++;
            }
        }

    }

    private void calculateAdjacentMineCount() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (grid[r][c].isMine()) {
                    continue;
                }

                int adjacentMineCount = countMinesAround(r, c);
                grid[r][c].setSurroundingMines(adjacentMineCount);
            }
        }
    }

    private int countMinesAround(int row, int col) {
        int count = 0;

        for (int ar = row - 1; ar <= row + 1; ar++) {
            for (int ac = col - 1; ac <= col + 1; ac++) {
                if (!isValidSpot(ar, ac)) {
                    continue;
                }

                if (ar == row && ac == col) {
                    continue;
                }

                if (grid[ar][ac].isMine()) {
                    count++;
                }

            }
        }
        return count;
    }

    public moveResult revealCell(int row, int col) {
        if (!isValidSpot(row, col)) {
            return moveResult.INVALID;
        }

        Cell cell = grid[row][col];

        if (cell.isCellRevealed()) {
            return moveResult.SPOT_REVEALED_ALREADY;
        }

        cell.setCellRevealed(true);

        if (cell.isMine()) {
            return moveResult.MINE_SPOT;
        }

        safeCellCount++;
        return moveResult.SAFE_SPOT;
    }

    public boolean gameWin() {
        int totalSafeSpots = (SIZE * SIZE) - MINES;
        return safeCellCount == totalSafeSpots;
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean isValidSpot(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

}

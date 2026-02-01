public class Cell {

    private boolean mine;
    private boolean cellRevealed;
    private int surroundingMines;

    public Cell() {
        this.mine = false;
        this.cellRevealed = false;
        this.surroundingMines = 0;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isCellRevealed() {
        return cellRevealed;
    }

    public void setCellRevealed(boolean cellRevealed) {
        this.cellRevealed = cellRevealed;
    }

    public int getSurroundingMines() {
        return surroundingMines;
    }

    public void setSurroundingMines(int surroundingMines) {
        this.surroundingMines = surroundingMines;
    }

}

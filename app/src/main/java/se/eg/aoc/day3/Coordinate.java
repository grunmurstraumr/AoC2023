package se.eg.aoc.day3;

public class Coordinate {
    private final int col;
    private final int row;

    public Coordinate(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isAdjacent(Coordinate other) {
        return (isAdjacentX(other) && isAdjacentY(other)) ||
                (isAdjacentX(other) && row == other.row) ||
                (isAdjacentY(other) && col == other.col) ||
                isAdjacentDiagonal(other);
    }

    boolean isAdjacentX(Coordinate other) {
        return Math.abs(col - other.col) == 1 || Math.abs(other.col - col) == 1;
    }

    boolean isAdjacentY(Coordinate other) {
        return Math.abs(row - other.row) == 1 || Math.abs(other.row - row) == 1;
    }

    boolean isAdjacentDiagonal(Coordinate other) {
        return (col - other.col == 1 && row - other.row == 1) || (other.col - col == 1 && other.row - row == 1);
    }
}

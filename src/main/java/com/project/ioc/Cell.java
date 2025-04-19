package com.project.ioc;

public class Cell {
    private int column;
    private int row;
    private CellType type;

    @Override
    public String toString() {
        return "Cell{" +
                "column=" + column +
                ", row=" + row +
                ", type=" + type +
                '}';
    }

    public Cell(int row, int column, CellType type) {
        this.column = column;
        this.row = row;
        this.type = type;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public CellType getType() {
        return type;
    }


}

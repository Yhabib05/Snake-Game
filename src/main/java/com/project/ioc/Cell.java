package com.project.ioc;

import java.util.Objects;


public class Cell {
    private int column;

    private int row;
    private CellType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return column == cell.column && row == cell.row  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

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

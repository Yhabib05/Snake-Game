package com.project.ioc;

enum CellType {
    EMPTY,
    FOOD,
    SNAKE;

    @Override
    public String toString() {
        return switch (this) {
            case EMPTY -> ".";
            case FOOD -> "F";
            case SNAKE -> "S";
        };
    }

}

package com.twu.refactoring;

public abstract class DirectionBase {
    public static final char DIR_NORTH = 'N';
    public static final char DIR_SOUTH = 'S';
    public static final char DIR_EAST = 'E';
    public static final char DIR_WEST = 'W';
    protected char currentDirection;
    DirectionBase(char currentDirection) {
        this.currentDirection = currentDirection;
    }
    DirectionBase() {}
    public abstract Direction turnLeft();
    public abstract Direction turnRight();
}

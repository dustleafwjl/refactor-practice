package com.twu.refactoring;

public class DirectionSouth extends DirectionBase{
    DirectionSouth() {
        this.currentDirection = DIR_SOUTH;
    }
    @Override
    public Direction turnLeft() {
        return new Direction(DIR_EAST);
    }

    @Override
    public Direction turnRight() {
        return new Direction(DIR_WEST);
    }
}

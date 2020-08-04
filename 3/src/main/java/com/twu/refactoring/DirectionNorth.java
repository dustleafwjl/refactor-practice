package com.twu.refactoring;

public class DirectionNorth extends DirectionBase{
    DirectionNorth() {
        this.currentDirection = DIR_NORTH;
    }
    @Override
    public Direction turnLeft() {
        return new Direction(DIR_WEST);
    }

    @Override
    public Direction turnRight() {
        return new Direction(DIR_EAST);
    }
}

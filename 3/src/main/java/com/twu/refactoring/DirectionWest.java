package com.twu.refactoring;

public class DirectionWest extends DirectionBase{
    DirectionWest() {
        this.currentDirection = DIR_WEST;
    }
    @Override
    public Direction turnLeft() {
        return new Direction(DIR_SOUTH);
    }

    @Override
    public Direction turnRight() {
        return new Direction(DIR_NORTH);
    }
}

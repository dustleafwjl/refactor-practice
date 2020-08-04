package com.twu.refactoring;

public class DirectionEast extends DirectionBase{
    DirectionEast() {
        this.currentDirection = DIR_EAST;
    }
    @Override
    public Direction turnLeft() {
        return new Direction(DIR_NORTH);
    }

    @Override
    public Direction turnRight() {
        return new Direction(DIR_SOUTH);
    }
}

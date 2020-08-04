package com.twu.refactoring;

public class Direction {
    public static final char DIR_NORTH = 'N';
    public static final char DIR_SOUTH = 'S';
    public static final char DIR_EAST = 'E';
    public static final char DIR_WEST = 'W';
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        switch (direction) {
            case DIR_NORTH:
                return new Direction(DIR_EAST);
            case DIR_SOUTH:
                return new Direction(DIR_WEST);
            case DIR_EAST:
                return new Direction(DIR_NORTH);
            case DIR_WEST:
                return new Direction(DIR_SOUTH);
            default:
                throw new IllegalArgumentException();
        }
    }

    public Direction turnLeft() {
        switch (direction) {
            case DIR_NORTH:
                return new Direction(DIR_WEST);
            case DIR_SOUTH:
                return new Direction(DIR_EAST);
            case DIR_EAST:
                return new Direction(DIR_NORTH);
            case DIR_WEST:
                return new Direction(DIR_SOUTH);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}

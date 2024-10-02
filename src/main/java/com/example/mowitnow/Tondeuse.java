package com.example.mowitnow;

public class Tondeuse {
    private int x, y, maxX, maxY;
    private char orientation;
    private String instructions;

    public Tondeuse(int x, int y, char orientation, String instructions, int maxX, int maxY) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions = instructions;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void executeInstructions() {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G':
                    turnLeft();
                    break;
                case 'D':
                    turnRight();
                    break;
                case 'A':
                    moveForward();
                    break;
            }
        }
    }

    private void turnLeft() {
        switch (orientation) {
            case 'N':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'N';
                break;
        }
    }

    private void turnRight() {
        switch (orientation) {
            case 'N':
                orientation = 'E';
                break;
            case 'E':
                orientation = 'S';
                break;
            case 'S':
                orientation = 'W';
                break;
            case 'W':
                orientation = 'N';
                break;
        }
    }

    private void moveForward() {
        switch (orientation) {
            case 'N':
                if (y < maxY) y++;
                break;
            case 'E':
                if (x < maxX) x++;
                break;
            case 'S':
                if (y > 0) y--;
                break;
            case 'W':
                if (x > 0) x--;
                break;
        }
    }

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }
}
package com.example.mowitnow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TondeuseTest {

    @Test
    public void testInitialPosition() {
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N', "GAGAGAGAA", 5, 5);
        assertEquals("1 2 N", tondeuse.toString());
    }

    @Test
    public void testTurnLeft() {
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N', "G", 5, 5);
        tondeuse.executeInstructions();
        assertEquals("1 2 W", tondeuse.toString());
    }

    @Test
    public void testTurnRight() {
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N', "D", 5, 5);
        tondeuse.executeInstructions();
        assertEquals("1 2 E", tondeuse.toString());
    }

    @Test
    public void testMoveForward() {
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N', "A", 5, 5);
        tondeuse.executeInstructions();
        assertEquals("1 3 N", tondeuse.toString());
    }

    @Test
    public void testComplexInstructions() {
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N', "GAGAGAGAA", 5, 5);
        tondeuse.executeInstructions();
        assertEquals("1 3 N", tondeuse.toString());
    }

    @Test
    public void testBoundaryConditions() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'S', "A", 5, 5);
        tondeuse.executeInstructions();
        assertEquals("0 0 S", tondeuse.toString());

        tondeuse = new Tondeuse(5, 5, 'N', "A", 5, 5);
        tondeuse.executeInstructions();
        assertEquals("5 5 N", tondeuse.toString());
    }

    @Test
    public void testMultipleInstructions() {
        Tondeuse tondeuse1 = new Tondeuse(1, 2, 'N', "GAGAGAGAA", 5, 5);
        tondeuse1.executeInstructions();
        assertEquals("1 3 N", tondeuse1.toString());

        Tondeuse tondeuse2 = new Tondeuse(3, 3, 'E', "AADAADADDA", 5, 5);
        tondeuse2.executeInstructions();
        assertEquals("5 1 E", tondeuse2.toString());
    }
}
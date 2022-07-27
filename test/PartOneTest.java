import org.junit.Test;

import static org.junit.Assert.*;


public class PartOneTest {

    @Test
    public void sample() {
        Rover rover = new Rover(4,2,"EAST");
        assertEquals("(6, 4) NORTH", rover.process("FLFFFRFLB"));
        assertEquals(6, rover.getCurrentPosition().getX());
        assertEquals(4, rover.getCurrentPosition().getY());
        assertEquals("NORTH", rover.getCurrentDirection());
    }

    @Test
    public void testInvalidCommand() {
        Rover rover = new Rover(-3,5,"SOUTH");
        assertEquals(" ABORT: A is not a valid command!", rover.process("BRBBBALBRF"));
        //////// to do
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(6, rover.getCurrentPosition().getY());
        assertEquals("WEST", rover.getCurrentDirection());
    }

    @Test
    public void rotationOnly() {
        Rover rover = new Rover(0,0,"EAST");
        assertEquals("(0, 0) EAST", rover.process("RRRRRRRRRLLLLLLLLL"));
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals("EAST", rover.getCurrentDirection());
    }

    @Test
    public void movementOnly() {
        Rover rover = new Rover(0,0,"SOUTH");
        assertEquals("(0, 0) SOUTH", rover.process("FFFFFFFBBBBBBB"));
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals("SOUTH", rover.getCurrentDirection());
    }

    @Test
    public void testForward() {
        Rover rover = new Rover(1,1,"NORTH");
        assertEquals("(1, 10) NORTH", rover.process("FFFFFFFFF"));
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(10, rover.getCurrentPosition().getY());
        assertEquals("NORTH", rover.getCurrentDirection());
    }

    @Test
    public void testBackward() {
        Rover rover = new Rover(1,1,"NORTH");
        assertEquals("(1, -8) NORTH", rover.process("BBBBBBBBB"));
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(-8, rover.getCurrentPosition().getY());
        assertEquals("NORTH", rover.getCurrentDirection());
    }

    @Test
    public void testRotateLeft() {
        Rover rover = new Rover(1,1,"NORTH");
        assertEquals("(1, 1) WEST", rover.process("LLLLL"));
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals("WEST", rover.getCurrentDirection());
    }

    @Test
    public void testRotateRight() {
        Rover rover = new Rover(1,1,"NORTH");
        assertEquals("(1, 1) EAST", rover.process("RRRRR"));
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(1, rover.getCurrentPosition().getY());
        assertEquals("EAST", rover.getCurrentDirection());
    }

    @Test
    public void test1() {
        Rover rover = new Rover(1,1,"NORTH");
        assertEquals("(-1, 3) WEST", rover.process("FLFFFRFLB"));
        assertEquals(-1, rover.getCurrentPosition().getX());
        assertEquals(3, rover.getCurrentPosition().getY());
        assertEquals("WEST", rover.getCurrentDirection());
    }

    @Test
    public void test2() {
        Rover rover = new Rover(-1,-1,"SOUTH");
        assertEquals("(1, -3) EAST", rover.process("FLFFFRFLB"));
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(-3, rover.getCurrentPosition().getY());
        assertEquals("EAST", rover.getCurrentDirection());
    }

    @Test
    public void test3() {
        Rover rover = new Rover(0,0,"EAST");
        assertEquals("(2, 2) NORTH", rover.process("FLFFFRFLB"));
        assertEquals(2, rover.getCurrentPosition().getX());
        assertEquals(2, rover.getCurrentPosition().getY());
        assertEquals("NORTH", rover.getCurrentDirection());
    }

    @Test
    public void test4() {
        Rover rover = new Rover(0,0,"WEST");
        assertEquals("(-2, -2) SOUTH", rover.process("FLFFFRFLB"));
        assertEquals(-2, rover.getCurrentPosition().getX());
        assertEquals(-2, rover.getCurrentPosition().getY());
        assertEquals("SOUTH", rover.getCurrentDirection());
    }

    @Test
    public void test5() {
        Rover rover = new Rover(-3,5,"NORTH");
        assertEquals("(-5, 3) EAST", rover.process("BRBBBLBRF"));
        assertEquals(-5, rover.getCurrentPosition().getX());
        assertEquals(3, rover.getCurrentPosition().getY());
        assertEquals("EAST", rover.getCurrentDirection());
    }

    @Test
    public void test6() {
        Rover rover = new Rover(-3,5,"SOUTH");
        assertEquals("(-1, 7) WEST", rover.process("BRBBBLBRF"));
        assertEquals(-1, rover.getCurrentPosition().getX());
        assertEquals(7, rover.getCurrentPosition().getY());
        assertEquals("WEST", rover.getCurrentDirection());
    }

}
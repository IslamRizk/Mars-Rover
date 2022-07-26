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
    public void testForward() {
        Rover rover = new Rover(1,1,"NORTH");
        assertEquals(String.format("(%d, %d) %s", 1, 10,"NORTH"), rover.process("FFFFFFFFF"));
    }

    @Test
    public void testBackward() {
        Rover rover = new Rover(1,1,"NORTH");
        assertEquals(String.format("(%d, %d) %s", 1, -8,"NORTH"), rover.process("BBBBBBBBB"));
    }

    @Test
    public void testRotateLeft() {
        Rover rover = new Rover(1,1,"NORTH");
        assertEquals(String.format("(%d, %d) %s", 1, 1,"WEST"), rover.process("LLLLL"));
    }

    @Test
    public void testRotateRight() {
        Rover rover = new Rover(1,1,"NORTH");
        assertEquals(String.format("(%d, %d) %s", 1, 1,"EAST"), rover.process("RRRRR"));
    }

    @Test
    public void sampleTest1() {
        Rover rover = new Rover(1,1,"NORTH");
        assertEquals(String.format("(%d, %d) %s", -1, 3,"WEST"), rover.process("FLFFFRFLB"));
    }
    @Test
    public void sampleTest2() {
        Rover rover = new Rover(-1,-1,"SOUTH");
        assertEquals(String.format("(%d, %d) %s", 1, -3,"EAST"), rover.process("FLFFFRFLB"));
    }
    @Test
    public void sampleTest3() {
        Rover rover = new Rover(0,0,"EAST");
        assertEquals(String.format("(%d, %d) %s", 2, 2,"NORTH"), rover.process("FLFFFRFLB"));
    }
    @Test
    public void sampleTest4() {
        Rover rover = new Rover(0,0,"WEST");
        assertEquals(String.format("(%d, %d) %s", -2, -2,"SOUTH"), rover.process("FLFFFRFLB"));
    }
    @Test
    public void sampleTest5() {
        Rover rover = new Rover(-3,5,"NORTH");
        assertEquals(String.format("(%d, %d) %s", -5, 3,"EAST"), rover.process("BRBBBLBRF"));
    }
    @Test
    public void sampleTest6() {
        Rover rover = new Rover(-3,5,"SOUTH");
        assertEquals(String.format("(%d, %d) %s", -1, 7,"WEST"), rover.process("BRBBBLBRF"));
    }

    @Test
    public void rotationOnly() {
        Rover rover = new Rover(0,0,"EAST");
        assertEquals("(0, 0) EAST", rover.process("RRRRRRRRRLLLLLLLLL"));
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals("EAST", rover.getCurrentDirection());
    }

}
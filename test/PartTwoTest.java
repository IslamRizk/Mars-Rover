import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class PartTwoTest {

    @Test
    public void sample() {
        HashSet<Point> obstacles = new HashSet<>(Arrays.asList(
                new Point(1,4),
                new Point(5,5),
                new Point(7,4)));
        Rover rover = new Rover(4,2,"EAST", obstacles);
        assertEquals("(5, 4) NORTH"+ " " +"STOPPED", rover.process("FLFFFRFLB"));
        assertEquals(5, rover.getCurrentPosition().getX());
        assertEquals(4, rover.getCurrentPosition().getY());
        assertEquals("NORTH", rover.getCurrentDirection());
    }
    @Test
    public void testInvalidCommand() {
        HashSet<Point> obstacles = new HashSet<>(Arrays.asList(
                new Point(1,4),
                new Point(5,5),
                new Point(7,4)));
        Rover rover = new Rover(-3,5,"SOUTH", obstacles);
        assertEquals(String.format(" ABORT: %c is not a valid command!", 'A'), rover.process("BRBBBALBRF"));
    }

    @Test
    public void testNoObstacles() {
        Rover rover = new Rover(-3,5,"SOUTH", new HashSet<>(Arrays.asList(
                new Point(-2,10),
                new Point(-7,6),
                new Point(8,7))));
        assertEquals("(-1, 7) WEST", rover.process("BRBBBLBRF"));
        assertEquals(-1, rover.getCurrentPosition().getX());
        assertEquals(7, rover.getCurrentPosition().getY());
        assertEquals("WEST", rover.getCurrentDirection());
    }

    @Test
    public void testUnableToMovement() {
        Rover rover = new Rover(0,0,"NORTH", new HashSet<>(Arrays.asList(
                new Point(0,1),
                new Point(1,0),
                new Point(-1,0),
                new Point(0,-1))));
        assertEquals("(0, 0) NORTH"+ " " +"STOPPED", rover.process("F"));
        assertEquals("(0, 0) NORTH"+ " " +"STOPPED", rover.process("B"));
        //assertEquals("(0, 0) WEST"+ " " +"STOPPED", rover.process("LF"));
        //assertEquals("(0, 0) EAST"+ " " +"STOPPED", rover.process("RF"));
        assertEquals("(0, 0) SOUTH", rover.process("LL"));
        assertEquals(0, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
    }

    @Test
    public void test1() {
        Rover rover = new Rover(1,1,"NORTH", new HashSet<>(Arrays.asList(
                new Point(1,4),
                new Point(-2,2),
                new Point(1,7))));
        assertEquals(String.format("(%d, %d) %s", -1, 2,"WEST")+ " " +"STOPPED", rover.process("FLFFFRFLB"));
        assertEquals("(-1, 2) WEST"+ " " +"STOPPED", rover.process("FLFFFRFLB"));
        assertEquals(-1, rover.getCurrentPosition().getX());
        assertEquals(2, rover.getCurrentPosition().getY());
        assertEquals("WEST", rover.getCurrentDirection());
    }

    @Test
    public void test2() {
        Rover rover = new Rover(-1,-1,"SOUTH", new HashSet<>(Arrays.asList(
                new Point(1,4),
                new Point(5,5),
                new Point(1,-3))));
        assertEquals("(2, -3) EAST"+ " " +"STOPPED", rover.process("FLFFFRFLB"));
        assertEquals(2, rover.getCurrentPosition().getX());
        assertEquals(-3, rover.getCurrentPosition().getY());
        assertEquals("EAST", rover.getCurrentDirection());
    }

    @Test
    public void test3() {
        Rover rover = new Rover(0,0,"EAST", new HashSet<>(Arrays.asList(
                new Point(1,4),
                new Point(1,1),
                new Point(1,7))));
        assertEquals("(1, 0) NORTH"+ " " +"STOPPED", rover.process("FLFFFRFLB"));
        assertEquals(1, rover.getCurrentPosition().getX());
        assertEquals(0, rover.getCurrentPosition().getY());
        assertEquals("NORTH", rover.getCurrentDirection());
    }

    @Test
    public void test4() {
        Rover rover = new Rover(0,0,"WEST", new HashSet<>(Arrays.asList(
                new Point(1,4),
                new Point(5,5),
                new Point(-2,-2))));
        assertEquals("(-2, -3) SOUTH"+ " " +"STOPPED", rover.process("FLFFFRFLB"));
        assertEquals(-2, rover.getCurrentPosition().getX());
        assertEquals(-3, rover.getCurrentPosition().getY());
        assertEquals("SOUTH", rover.getCurrentDirection());
    }

    @Test
    public void test5() {
        Rover rover = new Rover(-3,5,"NORTH", new HashSet<>(Arrays.asList(
                new Point(1,4),
                new Point(-3,4),
                new Point(1,7))));
        assertEquals("(-3, 5) NORTH"+ " " +"STOPPED", rover.process("BRBBBLBRF"));
        assertEquals(-3, rover.getCurrentPosition().getX());
        assertEquals(5, rover.getCurrentPosition().getY());
        assertEquals("NORTH", rover.getCurrentDirection());
    }




}
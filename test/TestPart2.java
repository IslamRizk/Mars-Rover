import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class TestPart2 {

    @Test
    public void testGaven() {
        Rover testPart2 = new Rover(4,2,"EAST", new HashSet<>(Arrays.asList(new Point(1,4), new Point(5,5), new Point(7,4))));
        assertEquals(String.format("(%d, %d) %s", 5, 4,"NORTH")+ " " +"STOPPED", testPart2.process("FLFFFRFLB"));
    }
    @Test
    public void testInvalidCommand() {
        Rover testPart2 = new Rover(-3,5,"SOUTH", new HashSet<>(Arrays.asList(new Point(1,4), new Point(5,5), new Point(7,4))));
        assertEquals(String.format(" ABORT: %c is not a valid command!", 'A'), testPart2.process("BRBBBALBRF"));
    }

    @Test
    public void testForward() {
        Rover testPart2 = new Rover(1,1,"NORTH", new HashSet<>(Arrays.asList(new Point(1,4), new Point(5,5), new Point(1,7))));
        assertEquals(String.format("(%d, %d) %s", 1, 3,"NORTH")+ " " +"STOPPED", testPart2.process("FFFFFFFFF"));
    }

    @Test
    public void sampleTest1() {
        Rover testPart2 = new Rover(1,1,"NORTH", new HashSet<>(Arrays.asList(new Point(1,4), new Point(-2,2), new Point(1,7))));
        assertEquals(String.format("(%d, %d) %s", -1, 2,"WEST")+ " " +"STOPPED", testPart2.process("FLFFFRFLB"));
    }
    @Test
    public void sampleTest2() {
        Rover testPart2 = new Rover(-1,-1,"SOUTH", new HashSet<>(Arrays.asList(new Point(1,4), new Point(5,5), new Point(1,-3))));
        assertEquals(String.format("(%d, %d) %s", 2, -3,"EAST")+ " " +"STOPPED", testPart2.process("FLFFFRFLB"));
    }
    @Test
    public void sampleTest3() {
        Rover testPart2 = new Rover(0,0,"EAST", new HashSet<>(Arrays.asList(new Point(1,4), new Point(1,1), new Point(1,7))));
        assertEquals(String.format("(%d, %d) %s", 1, 0,"NORTH")+ " " +"STOPPED", testPart2.process("FLFFFRFLB"));
    }
    @Test
    public void sampleTest4() {
        Rover testPart2 = new Rover(0,0,"WEST", new HashSet<>(Arrays.asList(new Point(1,4), new Point(5,5), new Point(-2,-2))));
        assertEquals(String.format("(%d, %d) %s", -2, -3,"SOUTH")+ " " +"STOPPED", testPart2.process("FLFFFRFLB"));
    }
    @Test
    public void sampleTest5() {
        Rover testPart2 = new Rover(-3,5,"NORTH", new HashSet<>(Arrays.asList(new Point(1,4), new Point(-3,4), new Point(1,7))));
        assertEquals(String.format("(%d, %d) %s", -3,5,"NORTH")+ " " +"STOPPED", testPart2.process("BRBBBLBRF"));
    }
    @Test
    public void sampleTest6() {
        Rover testPart2 = new Rover(-3,5,"SOUTH", new HashSet<>(Arrays.asList(new Point(-2,6), new Point(0,6), new Point(0,7))));
        assertEquals(String.format("(%d, %d) %s", -3, 6,"WEST")+ " " +"STOPPED", testPart2.process("BRBBBLBRF"));
    }
    @Test
    public void testNoObstacles() {
        Rover testPart2 = new Rover(-3,5,"SOUTH", new HashSet<>(Arrays.asList(new Point(-2,10), new Point(-7,6), new Point(8,7))));
        assertEquals(String.format("(%d, %d) %s", -1, 7,"WEST"), testPart2.process("BRBBBLBRF"));
    }


}
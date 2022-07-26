import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        //Rover rover = new Rover(-3,5,"SOUTH");
        Rover rover= new Rover(4,2,"EAST", new HashSet<>(Arrays.asList(new Point(0,0), new Point(6,5))));
        System.out.println(rover.process("BRBBBALBRF"));
    }

}

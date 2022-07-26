import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Rover {
    private final String[] DIRECTIONS = {"NORTH", "EAST", "SOUTH", "WEST"};
    private final HashMap<String, Point> STEPS ;

    private final HashSet<Point> OBSTACLES ;
    private Point currentPosition ;
    private int currentDirectionID ;

    public Rover(int x, int y, String direction) {
        currentPosition = new Point(x, y);
        currentDirectionID = getDirectionId(direction);
        STEPS = buildSteps();
        OBSTACLES = new HashSet<Point>();
    }

    public Rover(int x, int y, String direction, HashSet<Point> obstacles) {
        currentPosition = new Point(x, y);
        currentDirectionID = getDirectionId(direction);
        STEPS = buildSteps();
        OBSTACLES = obstacles;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public String getCurrentDirection() {
        return DIRECTIONS[currentDirectionID];
    }

    private int getDirectionId(String direction) {
        for (int i=0;i<DIRECTIONS.length;i++){
            if (DIRECTIONS[i].equals(direction)){
                return i;
            }
        }
        return -1;
    }

    private HashMap<String,Point> buildSteps() {
        return new HashMap<String,Point>(){{
            put("NORTH", new Point(0, 1));
            put("SOUTH", new Point(0, -1));
            put("WEST", new Point(-1, 0));
            put("EAST", new Point(1, 0));
        }};
    }

    public String process(String commands){

        for (char command : commands.toCharArray()) {
            if(command == 'R' ||command == 'L') {
                rotate(command);
            }else if(command == 'F' || command == 'B') {
               if(!move(command)){
                   return getStatus() + " " + "STOPPED";
               }
            }else {

                return String.format(" ABORT: %s is not a valid command!", command);
            }
        }

       return getStatus();
    }

    private boolean move(char command) {

        Point newPosition = getNewPosition(command);
        if(OBSTACLES.contains(newPosition)){
            return false;
        }

        currentPosition.setX(newPosition.getX());
        currentPosition.setY(newPosition.getY());
        return true;
    }

    private Point getNewPosition(char command){
        Point step = STEPS.get(DIRECTIONS[currentDirectionID]);
        Point newPosition = new Point(currentPosition.getX(), currentPosition.getY());
        if(command == 'F') {
            newPosition.add(step);
        }else {
            newPosition.sub(step);
        }
        return newPosition;
    }

    private void rotate(char command) {

        currentDirectionID += command == 'L' ? -1 : 1;

        currentDirectionID += DIRECTIONS.length;
        currentDirectionID %= DIRECTIONS.length;
    }

    //(6, 4) NORTH
    public String getStatus(){
       return String.format("(%d, %d) %s",
                currentPosition.getX(), currentPosition.getY(), DIRECTIONS[currentDirectionID]);
    }



}

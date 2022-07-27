# **Mars-Rover**
  Mars-Rover is build by **JAVA**

## **Prerequisites**
To get started, you will need on Your Windows : 

- **Java JDK-18** - [Download](https://www.oracle.com/java/technologies/downloads/#jdk18-windows) .
- **IntelliJ IDEA** - [Download](https://www.jetbrains.com/idea/download/#section=windows) .
- **JUnit 4.13** to Test - [Download](https://sourceforge.net/projects/junit-4.mirror/files/latest/download) .

## **Usage**
### Can run problem in two way
1. **Using main function**
    - Create instance of **Rover** class.
    - Passing current coordinates and the direction the rover is facing ``` X,  Y,  DIRECTIONS = {"NORTH", "EAST", "SOUTH", "WEST"} ```.
    - > Call **process** method, and it method take **Commands** string and return 
    the rover reports it's current coordinates and heading ``` obj.process("commands") ```.
    - Print the return of **process** method in the format    **```(X, Y) Direction```**.
     ---
    - to run **Part II** must add to instance object set of coordinates for all the known **obstacles**, e.g. ``` (X, y, Dir, setOfCoordinates) ```
      > setOfCoordinates = `new HashSet<>(Arrays.asList(new Point(0,0), new Point(1, 1), .....))`
    - Call **process** method, and it method take **Commands** string and return report position, heading and Stopped due to collision.
      > **Format report**  `(X, Y) Direction STOPPED`.
---
2. **Using unit test**
    - There are two file to test.
      - **PartOneTest**
      - **PartTwoTest**
      >**`In these two files there is the same code in Main Function to test problem with different test case, and compare between expected and actual result and return True or False`**
      


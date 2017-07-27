/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac HiFour.java
 *  Execution:    java HiFour name1 name2 name3 name4
 *
 *  Description: Prints "Hi name4, name3, name2, and name1" where "name1", 
 *  "name2", "name3" and "name4" are replaced by the command-line arguments, 
 *  reversing their order.
 *  
 *  Dependencies: None.
 * 
 *  % java HiFour Alice Bob Carol Dave
 *  Hi Dave, Carol, Bob, and Alice.
 *
 *
 *************************************************************************/

public class HiFour {

    public static void main(String[] args) {
        
        //outputs user input in reverse order
        System.out.print("Hi " + args[3] + ", " + args[2] + ", " 
        + args[1] + ", and " + args[0] + ".");
    }

}
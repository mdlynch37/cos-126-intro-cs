/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac Ordered.java
 *  Execution:    java Ordered integer1 integer2 integer3
 *
 *  Description: Prints "true" if given integers are either in ascending or 
 *  descending order, and prints "false" if not.
 *
 *  Dependencies: None.
 * 
 *  % java Ordered 10 17 49
 *  true
 *
 *  % java Ordered 49 17 10
 *  true
 *
 *  % java Ordered 10 49 17
 *  false
 *
 *************************************************************************/

public class Ordered {

    public static void main(String[] args) {
        //accepts three integers from user
        int integer1 = Integer.parseInt(args[0]);
        int integer2 = Integer.parseInt(args[1]);
        int integer3 = Integer.parseInt(args[2]);
        
        //tests if input is either in ascending or descending order
        boolean isOrdered = (integer1 > integer2) && (integer2 > integer3) 
                    || (integer1 < integer2) && (integer2 < integer3);
        
        //outputs results
        System.out.println(isOrdered);
        
    }

}
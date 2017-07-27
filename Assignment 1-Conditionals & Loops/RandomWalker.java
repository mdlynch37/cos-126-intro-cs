/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker N
 *
 *  Description: Runs a simulation of a random walker, where N, inputted by the
 *  user, is the number of steps the walker takes, each step being in a random 
 *  direction. The location of the walker after each step is outputted, ending 
 *  with an output of the squared distance of the walker from the starting point
 *
 *  Dependencies: None.
 * 
 *  % java RandomWalker 10
 *  (-1, 0)
 *  (-2, 0)
 *  (-2, 1)
 *  (-2, 0)
 *  (-2, -1)
 *  (-1, -1)
 *  (0, -1)
 *  (0, -2)
 *  (1, -2)
 *  (2, -2)
 *  squared distance = 8
 *
 *************************************************************************/

public class RandomWalker 
{
    public static void main(String[] args) 
    {
        // initialize N to user input
        int N = Integer.parseInt(args[0]);
        
        // initializes x and y coordinates of walker to 0
        int x = 0;
        int y = 0;
        
        // generates a step in a random direction until N steps have been taken
        while (N > 0)
        {
            double random = Math.random();
            
            // determines the direciton of the step
            if (random >= 0.75)      x++;
            else if (random >= 0.5)  x--;
            else if (random >= 0.25) y++;
            else                     y--;
            
            //  outputs the coordinates after the step
            System.out.println("(" + x + ", " + y + ")");
            
            //  substracts from the number of steps left
            N--;
        }
        
        //  calculates the squared distance from the walker's original 
        //  coordinates
        int squaredDistance = x*x + y*y;
        
        //  final output of calculated squared distance
        System.out.println("squared distance = " + squaredDistance);
        
    }
}
/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac RandomWalkers.java
 *  Execution:    java RandomWalkers N T
 *
 *  Description: Runs a simulation of a random walker T times where in each 
 *  simulation the walker takes N random steps (T and N are entered by the 
 *  user). After each simulation, the squared distance of the walker from the
 *  starting point is calculation to allow for the final output, which is the
 *  mean squared distance of all the simulations.
 *
 *  Dependencies: None.
 * 
 *  java RandomWalkers 1600 100000
 *  mean squared distance = 1597.85778
 *  
 *  java RandomWalkers 1600 100000
 *  mean squared distance = 1604.29052
 * 
 *
 *************************************************************************/

public class RandomWalkers 
{
    public static void main(String[] args) 
    {
        // initialize N and T to user input
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        
        //  total squared distance is initialized to 0
        double totalSquaredDistance = 0.0;
        
        // outer loop that runs each simulation T times
        for (int i = T; i > 0; i--)
        {
            // initializes x and y coordinates of walker to 0
            int x = 0;
            int y = 0;
            
            //  inner loop that runs the random walker simulation for N steps
            for (int j = N; j > 0; j--)
            {
                double random = Math.random();
            
                // determines the direciton of the step
                if (random >= 0.75)      x++;
                else if (random >= 0.5)  x--;
                else if (random >= 0.25) y++;
                else                     y--;
            }
        
            //  calculates the squared distance from the walker's original 
            //  coordinates
            int squaredDistance = x*x + y*y;
            
            //  adds squared distance of the current simmulation to the total
            totalSquaredDistance += squaredDistance;
        
        }
        
        //  calculates mean squared distance
        double meanSquaredDistance = totalSquaredDistance/T;
        
        //  final output of calculated mean squared distance
        System.out.println("mean squared distance = " + meanSquaredDistance);
        
    }
}
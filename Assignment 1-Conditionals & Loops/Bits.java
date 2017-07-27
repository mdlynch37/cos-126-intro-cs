/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac Bits.java
 *  Execution:    java Bits N
 *
 *  Description: Accepts integer N from user, then determines the number of 
 *  times N can be divided by 2 until it is stricly less than 0
 *
 *  Dependencies: None.
 * 
 *  % java Bits 16
 *  5
 * 
 *  % java Bits -23
 *  Illegal input
 *
 *
 *************************************************************************/

public class Bits 
{
    public static void main(String[] args) 
    {
        //  initialize N to user input
        int N = Integer.parseInt(args[0]);
        
        //  test for negative value
        if (N < 0)
        {
            System.out.println("Illegal input");
        }
        else
        {
            //  initialize counter to 0
            int counter = 0;
            
            //  while loop that divides N by two until N is stricly less than 1
            while (N >= 1)
            {
                N = N/2;
                counter++;
            }
            
            //  print results
            System.out.println(counter);
        }
    }
}


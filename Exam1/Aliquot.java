/*************************************************************************
 * Name: Murray Lynch
 * Login: mdlynch
 * Precept: P04
 *
 * Compilation:  javac-introcs Aliquot.java 
 * Execution:    java-introcs Aliquot n
 * 
 * Description: Takes N, inputed by user in the command line and returns the
 * aliuot sum, i.e. the sum of all of n's positive divisors other than itself
 * 
 * Dependencies: None
 * 
 *************************************************************************/

public class Aliquot
{
    public static void main(String[] args) 
    {
        // accept input from user
        int n = Integer.parseInt(args[0]);
        
        // initialize counter variable to 0
        int aliquotSum = 0;
        
        // loop that test for divisors from N/2 downward to 1 in integers
        for (int i = n/2; i > 0; i--)
        {
            // if i is a divisor of N, increment counter with i
            if (n % i == 0) aliquotSum += i;
        }
        
        // output in the given format
        System.out.println("The Aliquot sum of " + n + " is " + aliquotSum);

    }
}
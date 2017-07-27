/*************************************************************************
 * Name:
 * Login:
 * Precept:
 *
 * Description: Factorial reads in a command-line argument N, and prints
 * N! = 1 * 2 * ... * N to System output.
 *
 * Dependencies: None.
 *
 * Examples:
 * % java Factorial 0
 * 1
 * % java Factorial 1
 * 1
 * % java Factorial 5
 * 120
 * % java Factorial 12
 * 479001600
 * % java Factorial 20
 * 2432902008176640000
 *
 * Remarks:
 * - Would overflow a long if N > 20
 * - Need to use extended precision arithmetic to handle bigger factorials
 *************************************************************************/

public class Factorial {
    
    // recursive method to find factorial
    // assumes n >= 0 and n <= 20
    public static long factorial(long n) 
    {

         // base case
         if (n==1)
              return 1;

         // reduction step
         return n * factorial(n-1);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        System.out.println(factorial(N));
    }
}
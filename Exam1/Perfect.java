/*************************************************************************
 * Name: Murray Lynch
 * Login: mdlynch
 * Precept: P04
 * 
 * Compilation:  javac-introcs Perfect.java 
 * 
 * Description: Contains static methods aliquot, isPerfect and isAmicable
 *
 * Dependencies: None
 * 
 *************************************************************************/

public class Perfect
{
    // mehtod that returns the aliquot sum of n
    public static int aliquot(int n) 
    {   
        // initialize counter variable to 0
        int aliquotSum = 0;
        
        // loop that test for divisors from N/2 downward to 1 in integers
        for (int i = n/2; i > 0; i--)
        {
            // if i is a divisor of N, increment counter with i
            if (n % i == 0) aliquotSum += i;
        }
        
        // return Aliquot Sum
        return aliquotSum;
    }
    
    // returns true is n is a perfect number, returns false otherwise
    public static boolean isPerfect(int n)
    {
        if (n == aliquot(n)) return true;
        else return false; 
    }
    
    // returns true if n is an amicable number, returns false otherwise
    public static boolean isAmicable(int n)
    {
        // initializes n2 to the aliquot of n so n2 can be used to compare
        // with n
        int n2 = aliquot(n);
        
        // returns true if n is not a perfect number and it is the aliquot
        // of n2, n's aliquot
        if (isPerfect(n) == false && n == aliquot(n2)) return true;       
        else return false;
    }
}
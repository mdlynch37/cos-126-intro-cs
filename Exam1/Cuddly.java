/*************************************************************************
 * Name: Murray Lynch
 * Login: mdlynch
 * Precept: P04
 * 
 * Compilation:  javac-introcs Cuddly.java 
 * 
 * Description: Contains static methods aPeriod, isSociable and isCuddly
 *
 * Dependencies: None
 * 
 *************************************************************************/

public class Cuddly
{
    private static final int MAX = 30;

    // returns period of aliquot sequence starting at n if it exists
    // returns -1 otherwise
    public static int aPeriod(int n)
    {
        // initilizes n2 to n's aliquot sum to preserve n value to compare
        // for cycle
        int n2 = Perfect.aliquot(n);
        
        // loop that runs 30 times, i being 1 to count correctly for period
        for (int i = 1; i < MAX+1; i++)
        {
            if (n2 == n) return i;
            else n2 = Perfect.aliquot(n2);  
        }
        return -1;
    }
    
    // test if n is sociable, i.e. has a aliquot cycle period greater than 2
    // returns true if n is sociable, returns false otherwise
    public static boolean isSociable(int n)
    {
        if (aPeriod(n) > 2) return true;
        else return false;
    }
    
    // test if n is cuddly, i.e. is either amicable, perfect or sociable
    // returns true if n is cuddly, returns false otherwise
    public static boolean isCuddly(int n)
    {
        if (Perfect.isPerfect(n) || Perfect.isAmicable(n) || isSociable(n)) return true;
        else return false;
    }
}
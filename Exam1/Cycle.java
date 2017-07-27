/*************************************************************************
 * Name: Murray Lynch
 * Login: mdlynch
 * Precept: P04
 *
 * Compilation:  javac-introcs Cycle.java 
 * Execution:    java-introcs Cycle < inputs.txt
 * 
 * Description: Reads ints from StdInt and prints information about their
 * cuddliness
 * 
 * Dependencies: StdIn.java, StdOut.java
 * 
 *************************************************************************/

public class Cycle
{
    // prints aliquot cycle starting at n
    // method assumes that argument n is cuddly
    public static void printCycle(int n) 
    {
        
        StdOut.print(n);
        
        for (int i = 0; i < Cuddly.aPeriod(n)-1; i++)
        {
            n = Perfect.aliquot(n);
            StdOut.print(" " + n);
        }
    }
    
    
    public static void main(String[] args) 
    {
        
        while (!StdIn.isEmpty())
        {
            int n = StdIn.readInt();
            if (!Cuddly.isCuddly(n)) StdOut.println(n + " is not cuddly");
            else if (Perfect.isPerfect(n)) StdOut.println(n + " is perfect");
            else if (Cuddly.isSociable(n)) 
                StdOut.println(n + " is sociable: "); 
            else if (Perfect.isAmicable(n))
                StdOut.println(n + " is amicable: ");
        }        
    }
}
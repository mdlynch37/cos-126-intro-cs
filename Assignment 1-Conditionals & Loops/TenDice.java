/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac TenDice.java
 *  Execution:    java TenDice N
 *
 *  Description: Accepts user input, N, which is the number of simulations
 *  that the program will run, each simulation consisting of 10 rolls of a
 *  6-sided die. After each simulation, the total for that simulation is 
 *  tabulated into a string array that is set up to display output as a 
 *  frequency histogram.
 *
 *  Dependencies: None.
 *
 *************************************************************************/

public class TenDice 
{
    public static void main(String[] args) 
    {
        // initialize constants for number of sides on the die and number of
        // rolls per each simulation
        int NUM_ROLLS = 10;
        int NUM_SIDES = 6;
        
        // reads in user-provided number of simulations
        int N = Integer.parseInt(args[0]);

        // calculate the number of possible totals for each simulation
        int numPossibleTotals = (NUM_ROLLS * NUM_SIDES) - NUM_ROLLS + 1;
        
        // declares array that records total of each simulation
        String[] grandTotalFreq = new String[numPossibleTotals];
        
        // sets up array for specific output format
        for (int i = 0; i < numPossibleTotals; i++)
        {
            int total = i + NUM_ROLLS;
            grandTotalFreq[i] = total + ": ";
        }
        
        // outer loop that runs the simulation N times
        for (int i = 0; i < N; i++)
        {
            // variable that stores total for the simulation
            int totalOfRolls = 0;
            
            // inner loop that rolls the dice for the simulation
            for (int j = 0; j < NUM_ROLLS; j++)
            {
                totalOfRolls += (int) (Math.random()*6 + 1);
            }
            
            // adds * to the appropriate index value in the frequency array
            grandTotalFreq[totalOfRolls - NUM_ROLLS] += "*";

        }
        
        // displays frequecy array in the form of a histogram 
        for (int i = 0; i < numPossibleTotals; i++)
        {
           System.out.println(grandTotalFreq[i]);
        }
        
    }
    
}
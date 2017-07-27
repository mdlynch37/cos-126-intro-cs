/*********************************************************************** 
Murray Lynch
mdlynch
P07

Read in list size and permutations of that size.
Determine if each is a "derangement". 
Print out the first derangement if it exists.
Print out the number of derangements.

Requires StdIn and StdOut
***********************************************************************/

public class FoodPart2 {
    public static String best(String[] countries, int[] score) {
        
        //initialize and create index and maximum variables
        int maximum = 0;
        int index;
        
        //determine position and value of best score
        for (int i = 0; i < (score.length); i++) {
            if (maximum < score[i]) {
                maximum = score[i];
                index = i;
            }
        
        //set highest value to 0
        score[i] = 0;
        //return country with the highest value
        return countries[i];    
               
        }
        
    }
    
    
    public static void main(String[] args) {
        //read in number of countries
        int N = StdIn.readInt();
        
        int[] scores = new int[N];
        String[] countries = new String[N];
        
        //read in values from standard input
        for (int i = 0; i < N; i++)
        {
            countries[i] = StdIn.readString();
            scores[i] = StdIn.readInt();
        }
        
    }
}

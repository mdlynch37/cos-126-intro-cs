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

public class FoodPart1 {
    public static int score(int[] ratings) {        
        int sum = 0;
        int N = ratings.length;
        
        //calc raw total of scores
        for (int i = 0; i < N; i++)
            sum = sum + ratings[i];
        
        //calc min score
        int minimum = 20;
        for (int i = 0; i < (N-1); i++) {
           minimum = Math.min(ratings[i], ratings[i+1]);
        }    
        
        //calc max score
        int maximum = 0;
        for (int i = 0; i < (N-1); i++) {
           maximum = Math.max(ratings[i], ratings[i+1]);
        }
        
        //calc average
        int newSum = sum - (minimum + maximum);
        int average = (int) Math.round(newSum/(N-2));
        
        return average;
    }
    
    
    public static void main(String[] args) {
        //read in number of countries and judges
        int C = StdIn.readInt();
        int J = StdIn.readInt();
        
        //create arrays for countries, scores and averages
        String[] countries = new String[C];
        int[] ratings = new int[J];
        
        //print number of countries
        StdOut.println(C);
        
        //nested for that first reads name of country
        //then its scores, and then prints calculated average
        for (int i = 0; i < C; i++) {
            countries[i] = StdIn.readString();
            for (int j = 0; j < J; j++)
                ratings[j] = StdIn.readInt(); 
            StdOut.println(countries[i] + " " + score(ratings));
        }           
        
        
        
    }
}

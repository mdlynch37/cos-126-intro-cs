/************************************************************************
 * Name:
 * Login:
 * Precept:
 * 
 * Description: Distinct takes N integers as input and outputs true
 * if all the inputs have different values, false otherwise.
 *
 * Dependencies: None.
 *
 * Examples:
 * > java Distinct 11 23 -7 0 99 5 42
 * true
 * > java Distinct 2 4 6 3 6
 * false
 * > java Distinct -3 -2 -1 -0 3 2 1 0 
 * false 
 *
 * Note: The last one is false because the integer -0 equals integer 0.
 ***********************************************************************/

public class Distinct {
    public static void main(String[] args) {

        // N is the number of command-line arguments 
        int N = args.length;    
         
        // convert each arg and store them in an array of integers
        int[] values = new int[N];
        for (int i = 0; i < N; i++)
            values[i] = Integer.parseInt(args[i]);    
        
        // are all of the pairs examined so far distinct?
        boolean result = true;

        // we'll examine each values[i] in the array 
        for (int i = 0; i < N; i++) {
            // we'll examine values[j] for each other j
            for (int j = i+1; j < N; j++) {
                // are they different or not?
                if (values[j] == values[i]) {
                    result = false;
                }
            }
        }
         
        System.out.println(result);
    }
}
/*********************************************************************
 * Name:
 * Login:
 * Precept:
 *  
 * Description: HowMany takes a variable number of command-line
 * arguments and prints a message reporting how many there are.
 *
 * Dependencies: None.
 * 
 * > java HowMany
 * You entered 0 command-line arguments.
 * > java HowMany Alice Bob Carol
 * You entered 3 command-line arguments.
 * > java HowMany Alice                            This is Booksite
 * You entered 1 command-line argument.            Web Exercise 1.4.1
 ********************************************************************/

public class HowMany {
    public static void main(String[] args) {

        // number of command-line arguments
        int N = args.length;
 
        // output message
        System.out.print("You entered " + N + " command-line argument");
        if (N==1) System.out.println(".");
        else            System.out.println("s.");
    }
}
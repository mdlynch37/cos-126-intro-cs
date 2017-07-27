
/*************************************************************************
 * Name         : Murray Lynch
 * NetID        : mdlynch
 * Precept      : P04
 *
 * Dependencies : None
 * Description  : Creates class to simulate a linear feedback shift register 
 *                of custom size that can generate a pseudo-random k-bit integer
 *                produced from k steps of the lfsr, each step outputting a 
 *                pseudo-random bit.
 *                The main method contains a few tests cases for other methods
 *                in the class.
 *  
 *************************************************************************/

public class LFSR 
{
    // declare instance variables
    private int N;       // number of bits in the LFSR
    private int[] reg;   // reg[i] = ith bit of LFSR, reg[0] is rightmost bit
    private int tap;     // index of the tap bit

    // constructor to create LFSR with the given initial seed and tap
    public LFSR(String seed, int t) 
    {
        // instantiate tap instance variable
        tap = t;
        
        // instantiate instance variable N
        N = seed.length();
        
        // initialize reg array to length of LFSR
        reg = new int[N];
        
        // declare char variable to store a character from seed string
        char c;
        
        // for each character in seed string, assign value in reg array
        // with bit indexed from right to left
        for (int i = 0; i < N; i++)
        {
            c = seed.charAt(i);
            if (c == '0')
                reg[N-i-1] = 0;
            else reg[N-i-1] = 1;
        }
    }
  
    // simulate one step and return the new bit as 0 or 1
    public int step() 
    {
        // calculates new bit
        int newBit = reg[N-1] ^ reg[tap];
        
        // shifts bits to the left
        for (int i = 0; i < N-1; i++)
        {
            reg[N-i-1] = reg[N-i-2];
        }
        // assigns right-most bit value of new bit
        reg[0] = newBit;
        
        // returns new bit
        return newBit;
    }
  
    // simulate k steps and return k-bit integer
    public int generate(int k) 
    {
        // k-bit integer initialization
        int counter = 0;
        
        // run step method k times, increasing counter variable with the
        // appropriate arithmetic
        for (int i = 0; i < k; i++)
        {
            counter = 2*counter + step();  
        }
        
        return counter;
    }

    // return a string representation of the LFSR
    public String toString()  
    {
        // initialize register string to empty string
        String regString = "";
        
        // concatenate each bit in the LSFR to regString
        for (int i = 0; i < N; i++)
        {
            regString = regString.concat(Integer.toString(reg[N-i-1]));
        }

        // return string of register
        return regString;
    }
   
  
    // test all of the methods in LFSR
    public static void main(String[] args)  
    {
        // first test
        LFSR lfsr1 = new LFSR("01101000010", 8);
        for (int i = 0; i < 10; i++) 
        {
            int bit = lfsr1.step();
            StdOut.println(lfsr1 + " " + bit);
        }
        
        // spacing between tests
        StdOut.println();
        
        // second test
        LFSR lfsr2 = new LFSR("01101000010", 8);
        for (int i = 0; i < 10; i++) 
        {
            int r = lfsr2.generate(5);
            StdOut.println(lfsr2 + " " + r);
        }
        
        // spacing between tests
        StdOut.println();
         
        // third test
        LFSR lfsr3 = new LFSR("01101000010100010000", 16);
        for (int i = 0; i < 10; i++) 
        {
            int r = lfsr3.generate(8);
            StdOut.println(lfsr3 + " " + r);
        }
    }

}


/*************************************************************************
 *  Name(s)      : Murray Lynch
 *  NetID(s)     : mdlynch
 *  Precept(s)   : P04
 *  
 *  Dependencies: ST.java StdRandom.java
 *
 *  Description: Class creates immutable data type MarkovModel which populates
 *  symbol table for each sequence of characters of length k (a kgram) in the 
 *  provided text. It also generates random characters from probability 
 *  distribution recorded in symbol table, as well as an iterative generator
 *  of new text of length T from the random method.
 *
 ****************************************************************************/

public class MarkovModel
{
    //number of ASCII characters supported, starting from 0
    private static final int NUM_CHARS = 128;
    private ST<String, int[]> st; //symbol table contain Markvo model
    private int k; //size of kgram

    // create a Markov model of order k from given text
    // Assume that text has length at least k.
    public MarkovModel(String text, int k)
    {
        this.k = k;
        
        //store length of text before making it circular
        int length = text.length();
        
        //append text to make it circular 
        String firstKgram = text.substring(0, k);
        String circText = text + firstKgram;

        //initialize symbol table
        st  = new ST<String, int[]>();
        
        //populate symbol table looking at each character to create all
        //possible kgrams
        for (int i = 0; i < length; i++)
        {
            //establish current kgram
            String kgram = circText.substring(i, i+k);
            
            if (!st.contains(kgram))
                st.put(kgram, new int[NUM_CHARS]);
            
            //extract frequency array, increment appropriate element and update
            //symbol table
            int[] freq = st.get(kgram);  
            char next = circText.charAt(i+k);
            freq[next]++;
            st.put(kgram, freq);
        }
    }
    
    // Returns order k of Markov model
    public int order()     
    {
        return k;
    }
    
    // Returns number of occurrences of kgram in text
    // (throw an exception if kgram is not of length k)
    public int freq(String kgram)   
    {
        if (kgram.length() != k)
            throw new RuntimeException("kgram is not of length k");
        
        //return 0 if kgram not in symbol table
        if (!st.contains(kgram))
            return 0;
        
        //initialize variable to count frequency
        int counter = 0;
        
        //extract frequency array for analysis
        int[] freq = st.get(kgram);
        
        //for each element in the frequency array, increment counter by 
        //element's value
        for (int i = 0; i < NUM_CHARS; i++)
            counter += freq[i];
        
        return counter;
    }
    
    // Returns number of times that character c follows kgram
    // (throw an exception if kgram is not of length k)
    public int freq(String kgram, char c)     
    {
        if (kgram.length() != k)
            throw new RuntimeException("kgram is not of length k");
        
        //return 0 if kgram not in symbol table
        if (!st.contains(kgram))
            return 0;
        
        int[] freq = st.get(kgram);
        
        return freq[c];  
    }
    
    // Returns a random character following given kgram
    // (Throw an exception if kgram is not of length k.
    //  Throw an exception if no such kgram.)
    public char rand(String kgram)     
    {        
        if (kgram.length() != k)
            throw new RuntimeException("kgram is not of length k");
        
        if (!st.contains(kgram))
            throw new RuntimeException("No such kgram");

        int[] freq = st.get(kgram); //extract freq array for given kgram
        double occurences = freq(kgram); //establish total number of occurences
        //create new array for probabilities of each character
        double[] probabilities = new double[NUM_CHARS]; 
        
        //populate probabilities array
        for (int i = 0; i < NUM_CHARS; i++)
            probabilities[i] = freq[i]/occurences;
        
        //cast result of discrete random probaiblities method
        char randomChar = (char) StdRandom.discrete(probabilities);
        
        return randomChar;
    }
    
    // generate a String of length T characters
    // by simulating a trajectory through the corresponding
    // Markov chain.  The first k characters of the newly
    // generated String should be the argument kgram.
    // Assume that T is at least k.
    public String gen(String kgram, int T) 
    {
        //create new StringBuilder object to builder generated text
        //initialized with starting kgram given by parameter variable
        StringBuilder string = new StringBuilder(kgram);
        
        //loop through each needed character after kgram, generating 
        //random characters based on the current kgram's probability 
        //distribution
        String nextKgram = kgram;
        for (int i = 1; i <= T-k; i++)
        {        
            //append random character
            string.append(rand(nextKgram));
                
            //advance to next kgram
            nextKgram = string.substring(i, i+k);
        }
        
        return string.toString();
    }
    
    //MarkovModel method testing
    public static void main(String[] args) 
    {
        //Test of constructor and freq methods, provided in checklist
        MarkovModel mod1 = new MarkovModel("banana", 2);
        StdOut.println("freq(\"an\", 'a')    = " + mod1.freq("an", 'a'));
        StdOut.println("freq(\"na\", 'b')    = " + mod1.freq("na", 'b'));
        StdOut.println("freq(\"na\", 'a')    = " + mod1.freq("na", 'a'));
        StdOut.println("freq(\"na\")         = " + mod1.freq("na"));
        StdOut.println();

        //Test of constructor and freq methods, provided in checklist
        String text = "one fish two fish red fish blue fish"; 
        MarkovModel mod2 = new MarkovModel(text, 4);
        StdOut.println("freq(\"ish \", 'r') = " + mod2.freq("ish ", 'r'));
        StdOut.println("freq(\"ish \", 0)   = " + mod2.freq("ish ", (char) 0));
        StdOut.println("freq(\"ish \")      = " + mod2.freq("ish "));
        StdOut.println("freq(\"tuna\")      = " + mod2.freq("tuna"));
        StdOut.println();
        
        //Counter loop to test rand method. 
        //Ensure counter output is approxiamtely 2500
        int counter = 0;        
        for (int i = 0; i < 10000; i++)
        {
            char test = mod2.rand("fish");
            if (test == 'o') counter++;     
        } 
        StdOut.println(counter);
        StdOut.println();

        //test of gen method
        String text2 = "abac";
        MarkovModel mod3 = new MarkovModel(text2, 1);
        StdOut.println(mod3.gen("a", 100));
    }
}
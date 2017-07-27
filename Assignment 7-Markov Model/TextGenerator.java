
/*************************************************************************
 *  Name(s)      : Murray Lynch
 *  NetID(s)     : mdlynch
 *  Precept(s)   : P04
 *  
 *  Compilation:  javac-introcs TextGenerator.java
 *  Execution:    java-introcs TextGenerator k T < textfile.txt
 *  Dependencies: MarkovModel.java ST.java StdRandom.java
 *
 *  Description: Client program that creates MarkovModel object from provided
 *  text, and uses methods from MarkovModel class to generate text of length
 *  T by simulating the movement of a Markov chain. 
 *  We assume text has at least length k, and that T >= k.
 *
 ****************************************************************************/

public class TextGenerator
{
    public static void main(String[] args) 
    {
        //read integers from user input
        int k = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        
        //reads remainder of input stream
        String text = StdIn.readAll();
        
        //create new markov model from text with provided length of k gram
        MarkovModel morkov = new MarkovModel(text, k);
        
        //reads first kgram from beginning of text
        String firstKgram = text.substring(0, k);
        
        //runs through the trajectory of a markov chain, creating output of
        //length T, starting with first k characters from inputted text
        String result = morkov.gen(firstKgram, T);
        
        StdOut.println(result);
        StdOut.println();
    }
    
}
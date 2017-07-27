
/*************************************************************************
 *  Name(s)      : Murray Lynch
 *  NetID(s)     : mdlynch
 *  Precept(s)   : P04
 *  
 *  Compilation:  javac GuitarHero.java
 *  Execution:    java  GuitarHero
 *  Dependencies: StdAudio.java StdDraw.java GuitarString.java
 *                RingBuffer.java
 *
 *  Description: 
 *  Plays 37 guitar strings when the user when use types corresponding keys
 *  on the keyboard within the standard drawing window
 *
 ****************************************************************************/

public class GuitarHero {

    public static void main(String[] args) {

        // constants to describe key layout matching notes to be played by 
        // guitar simulation
        String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        int NUM_NOTES = KEYBOARD.length();
        
        // frequency of base note concert A
        double CONCERT_A = 440.0;
        
        // creates an array of guitar strings, each element corresponding
        // to its matched key on the keyboard
        GuitarString[] strings = new GuitarString[NUM_NOTES];
        
        // for each string, calculate its frequency, then call constructor
        // method with that frequency to create the string
        for (int i = 0; i < NUM_NOTES; i++)
        {
            double frequency = CONCERT_A * Math.pow(2, (i-24)/12.0);
            strings[i] = new GuitarString(frequency);
        }


        // the main input loop
        while (true) 
        {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) 
            {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // store the index value of that character
                int keyIndex = KEYBOARD.indexOf(key);

                // pluck the corresponding string as long as key pressed matches
                // a string
                if (keyIndex != -1)
                {
                    strings[keyIndex].pluck();
                }
            }

            
            // initialize sample variable
            double sample = 0;
            
            // compute the superposition of the samples
            for (int i = 0; i < NUM_NOTES; i++)
            {
                sample += strings[i].sample();
            }
            
            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (int i = 0; i < NUM_NOTES; i++)
            {
                strings[i].tic();
            }
        }
    }

}
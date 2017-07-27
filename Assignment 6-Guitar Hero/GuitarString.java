
/*************************************************************************
 * Name(s)      : Murray Lynch
 * NetID(s)     : mdlynch
 * Precept(s)   : P04
 *
 * Dependencies : RingBuffer.java StdAudio.java
 * Description  : This class creates a data type which models a vibrating guitar
 *                string with the RingBuffer data type, using the Karplus-Strong 
 *                algorithm. 
 *                Methods that simulate the movement of a plucked string, 
 *                updating the ring buffer and returning the current sample.
 *  
 *
 *****************************************************************************/

public class GuitarString 
{

    // constants for sampling rate and decay factor
    private static final int SAMPLING_RATE = 44100;
    private static final double DECAY_FACTOR = .996;
    
    // ring buffer
    private RingBuffer buffer; 
    
    // capacity of the buffer
    private int N;
    
    // declare and initialize counter of tic simulations
    private int numSimulations = 0;

    // create guitar string of given frequency, using sampling rate of 44,100
    public GuitarString(double frequency) 
    {
        // calculate the capacity of the buffer for the created string
        N = (int) Math.ceil(SAMPLING_RATE/frequency);
        
        // create new buffer of size N
        buffer = new RingBuffer(N);
        
        // initialize all elements of buffer to 0
        for (int i = 0; i < N; i++) 
        {
            buffer.enqueue(0.0);
        }            
            
    }

    // create a guitar string with size & initial values given by the array
    public GuitarString(double[] init) 
    {
        // assign buffer size to given argument array's size
        N = init.length;
        
        // create new buffer of size N
        buffer = new RingBuffer(N);
        
        // fill buffer with values from given argument array
        for (int i = 0; i < N; i++) 
        {
            buffer.enqueue(init[i]);
        }            
        
    }

    // pluck the guitar string by replacing the buffer with white noise
    public void pluck() 
    {
        // create new buffer of size N
        buffer = new RingBuffer(N);

        // Fill buffer with random values between -0.5 and +0.5
        for (int i = 0; i < N; i++) 
        {
            buffer.enqueue(Math.random() - 0.5);
        }   
    }

    // advance the simulation one time step
    public void tic() 
    {
        // calculate new value for the front of the buffer using 
        // the Karplus-Strong algorithm
        double update = DECAY_FACTOR * (buffer.dequeue() + buffer.peek()) / 2;
        buffer.enqueue(update);
        
        // increment counter for number of Simulations
        numSimulations++;
    }

    // return the current sample
    public double sample() 
    {
        return buffer.peek();
    }

    // return number of times tic was called
    public int time() 
    {
        return numSimulations;
    }

    
    // a simple test of the constructor and methods in GuitarString provided by
    // course instructor in assignment template
    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]);
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < N; i++) 
        {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }

}
